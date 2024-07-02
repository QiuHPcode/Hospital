<template>
	<view>
		<view v-if="none||recordlist.length==0" style="display: flex; justify-content: center; font-size: 50rpx; margin-top: 2vh; color: #5d5d5d;">
			暂无预约记录!
		</view>
		<view v-else>
			<view style="display: flex; justify-content: center; font-size: 50rpx; margin-top: 2vh; color: #5d5d5d;">
				预约记录:
			</view>
			<view v-for="(item,index) in recordlist" :key="item.yid">
				<uni-card>
					<view style="display: flex; align-items: center; font-size: 38rpx;">
						<view style="color: #5d5d5d; font-weight: bold;">
							时间:
						</view>
						<view style="justify-content: center; margin-left: auto; margin-right: 2vw;">
							{{item.daytime}}{{item.infotime==1?'上午':'下午'}}
						</view>
					</view>
					<view style="display: flex;align-items: center;">
						<view style="color: #5d5d5d; font-weight: bold; ">
							医院:
						</view>
						<view style="justify-content: center; margin-left: auto; margin-right: 2vw;">
							{{item.hname}}
						</view>
					</view>
					<view style="display: flex;align-items: center;">
						<view style="color: #5d5d5d; font-weight: bold; ">
							科室:
						</view>
						<view style="justify-content: center; margin-left: auto; margin-right: 2vw;">
							{{item.pname}}
						</view>
					</view>
					<view style="display: flex;align-items: center;">
						<view style="color: #5d5d5d; font-weight: bold; ">
							医生:
						</view>
						<view style="justify-content: center; margin-left: auto; margin-right: 2vw;">
							{{item.doc.dname}}
						</view>
						<view style="color: #5d5d5d; font-weight: bold; ">
							性别:
						</view>
						<view style="justify-content: center;margin-left: auto; margin-right: 2vw;" :style="{color:item.doc.gender == 1?'blue':'pink'}">
							{{item.doc.gender == 1?'男':'女'}}
						</view>
						<view style="color: #5d5d5d; font-weight: bold; ">
							职称:
						</view>
						<view style="justify-content: center; margin-left: auto; margin-right: 2vw;">
							{{item.doc.jt}}
						</view>
					</view>
					<view style="display: flex;align-items: center;">
						<view  style="color: #5d5d5d; font-weight: bold; ">
							状态:
						</view>
						<view v-if="item.yon == 1" style="color: green; justify-content: center;margin-left: auto;margin-right: 2vw;">
							完成预约
						</view>
						<view v-else-if="item.yon == 2" style="color: red;  justify-content: center;margin-left: auto;margin-right: 2vw;">
							违约
						</view>
						<view v-else-if="item.yon == 3" style="color: green;  justify-content: center;margin-left: auto;margin-right: 2vw;">
							待完成
						</view>
						<view v-else-if="item.yon == 4" style="color: gray;  justify-content: center;margin-left: auto;margin-right: 2vw;">
							取消中...
						</view>
						<view v-else-if="item.yon == 5" style="color: darkgray; justify-content: center;margin-left: auto;margin-right: 2vw;">
							已取消
						</view>
						<view v-if="item.yon == 3" style="justify-content: center;margin-left:auto;margin-right: 2vw; display: flex; align-items: center;">
							<button @click="open(item.yid)" type="primary" style="background-color: cornflowerblue; border-radius: 30vw; font-size: 28rpx; height: 50rpx;display: flex; text-align: center; align-items: center;justify-content: center;">取消预约</button>
						</view>
					</view>		
				</uni-card>
			</view>
		</view>
		<view>
			<uni-popup  ref="popup" >
				<view class="info" style="height: 30vh;border-top-left-radius: 2vh;border-top-right-radius: 2vh;width: 100vw;">
					<view style="display: flex; align-items: center; justify-content: center;font-weight: bold;padding-top: 1vh;">
						取消预约
					</view>
					<view style="padding-top: 3vh; width: 90vw;padding-left: 5vw;">
						<uni-easyinput style="display: flex;align-items: center;justify-content: center;" type="textarea" v-model="value" placeholderStyle="font-size:38rpx;"  placeholder="*请输入取消缘由"></uni-easyinput>
					</view>
					<view style="display: flex; justify-content: center; align-items: center; padding-top: 3vh;">
						<button @click="finishcancel" :disabled="value==''" style="width: 70vw;border-radius: 10vw;background-color: cornflowerblue;" type="primary" >确定取消</button>
					</view>
				</view>
			</uni-popup>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				uid:'',
				recordlist:[],
				value:'',
				none:false,
				selectid:''
			}
		},
		onLoad() {
			this.uid = uni.getStorageSync('user').uid;
			this.getrecord();
		},
		methods: {
			open(index){
				if(this.selectid !=index){
					this.value ='';
					this.selectid = index;
				}
				this.$refs.popup.open('bottom');
			},
			finishcancel(){
				let that = this;
				console.log('取消',this.value);
				uni.request({
					url:'http://localhost:8080/updatecancel',
					method:'POST',
					data:{
						'uid':this.uid,
						'yid':this.selectid,
						'text':this.value
					},
					success: (response) => {
						const data = response.data;
						if(data.code ==200){
							uni.showToast({
								title:'提交成功',
								mask:true
							});
							that.recordlist = data.data;
							that.value ='';
							setTimeout(()=>{
								that.$refs.popup.close();
							},300)
						}
						else{
							uni.showToast({
								title:'提交失败',
								icon:'error'
							});
						}
					},
					fail: (err) => {
						uni.showToast({
							title:'服务器错误',
							icon:'error'
						})
					}
				})
			},
			getrecord(){
				let that = this;
				uni.request({
					url:'http://localhost:8080/getrecord',
					method:'POST',
					data:{
						'uid':this.uid
					},
					success: (response) => {
						let data = response.data;
						if(data.code == 200){
							console.log(data.data);
							that.recordlist = data.data;
							that.none = false;
							
						}else if(data.code == 404){
							
						}else{
							that.none  =true;
							uni.showToast({
								title:'服务器错误',
								icon:'error'
							})
							setTimeout(()=>{
								uni.switchTab({
									url: '/src/components/Repair'
								})
							},500)
						}
						
					},
					fail: (err) => {
						that.none  =true;
						uni.showToast({
							title:'错误',
							icon:'error'
						})
						setTimeout(()=>{
							uni.switchTab({
								url: '/src/components/Repair'
							})
						},500)
					}
					
				})
			}
		}
	}
</script>

<style>
	.info {
			width: 100%;
			height: 50vh;
			background-color: #fff;
			border-top-left-radius: 2vh;
			border-top-right-radius: 2vh;
		}
</style>
