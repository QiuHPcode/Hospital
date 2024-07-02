<template>
	<view>
		<view >
			<view style="margin-top: 2vw; text-align: center; display: flex; justify-content: center; align-items: center; font-size: 30px; font-weight:bold;">
				{{doc.hname}}
			</view>
			<view style="margin-top: 1vw; text-align: center; display: flex; justify-content: center; align-items: center; font-size: 20px; font-weight:bold;">
				科室：{{doc.pname}}
			</view>
			<view style="border-bottom: 2px solid #000; text-align: center; font-weight: bold;">
				医生：{{doc.dname}}
			</view>
		</view>
		<view style="margin-left: 2vw;font-weight: bold;">
			请选择时间段进行预约:
		</view>
		<view class="container">
			<view v-for="(item,index) in recordcount" :key="item.yyid">
				
				<view @click="timeselect(item.yyid)" class="people" :style="{'background-color':selecttime==item.yyid ?(item.people ==0?'#dfdfdf':'#ffffc7')  :(item.people ==0?'#dfdfdf':'#fff') }">
					<view>
						{{item.daytime}}{{item.infotime ==1?'上午':'下午'}}
					</view>
					<view :style="{color:item.people ==0 ?'#dd0000'  :'#000','font-weight': 'bold'}">
						{{item.people}}人
					</view>
				</view>
				
			</view>
		</view>
		<view style="margin-top: 2vh;">
			<button @click="yycom" type="primary" :style="{'background-color':selecttime==0||dis?'#ccc':'#94c3ff'}" :disabled="selecttime==0||dis" style="width: 60vw; border-radius: 20vw;font-weight: bold;">点击预约</button>
		</view>
	</view>
	

</template>

<script>
	export default {
		data() {
			return {
				doc:[],
				recordcount:[],
				selecttime:0,
				dis:false,
				user:''
			}
		},
		onLoad(options) {
			let doc = JSON.parse(options.doc);
			console.log(doc);
			this.doc = doc;
			this.user = uni.getStorageSync('user');
			this.getdocCount();
		},
		methods: {
			yycom(){
				let that = this;
				uni.request({
					url:'http://localhost:8080/finishyyp',
					method:'POST',
					data:{
						'yyid':this.selecttime,
						'uid': this.user.uid	
					},
					success: (response) => {
						const data = response.data;
						console.log(data.code);
						if(data.code ==200){
							uni.showToast({
								title:'预约成功',
								mask:true
							})
							setTimeout(()=>{
								uni.switchTab({
									url:'/src/components/index'
								})
							},500)
						}else if(data.code == 404){
							that.recordcount = data.data;
							uni.showToast({
								title:'没有名额请重试',
								icon:'error'
							})
						}else if(data.code == 403){
							that.recordcount = data.data;
							uni.showToast({
								title:'已经预约勿重复',
								icon:'error'
							})
						}
						else{
							uni.showToast({
								title:'服务器错误',
								icon:'error'
							})
						}
					},
					fail: (err) => {
						uni.showToast({
							title:'错误',
							icon:'error'
						})
					}
				})
			},
			timeselect(index){
				this.selecttime = index;
				for(var i=0;i<this.recordcount.length;i++){
					if(this.recordcount[i].yyid == this.selecttime){
						if(this.recordcount[i].people ==0){
							this.dis = true;
							return;
						}
					}
				}	
				this.dis = false;
			},
			getdocCount(){
				let that = this;
				uni.request({
					url:'http://localhost:8080/getdoccount',
					method:'POST',
					data:{
						'did':this.doc.did
					},
					success: (response) => {
						let data = response.data;
						if(data.code == 200){
							that.recordcount = data.data;
						}
						else{
							uni.showToast({
								title:'服务器错误',
								icon:'error'
							})
							setTimeout(()=>{
								uni.switchTab({
									url:'/src/components/index'
								})
							},500)
						}
						console.log(data);
					},
					fail: (err) => {
						uni.showToast({
							title:'错误',
							icon:'error'
						})
					}
				})
			}
		}
	}
</script>

<style>
	.container{
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
		
		
	}
	.people{
		border-radius: 10px; 
		width: 45vw; 
		text-align: center; 
		height: 40px; 
		margin-left: 2vw; 
		margin-right: 2vw; 
		margin-top: 2vh;
	}
</style>
