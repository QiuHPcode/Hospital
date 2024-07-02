<template>
	<view>
		<view style="margin-top: 2vw; text-align: center; display: flex; justify-content: center; align-items: center; font-size: 30px; font-weight:bold;">
			{{hname}}
		</view>
		<view style="margin-top: 1vw; text-align: center; display: flex; justify-content: center; align-items: center; font-size: 20px; font-weight:bold;">
			科室：{{pname}}
		</view>
		<view style="border-bottom: 2px solid #000; text-align: center; font-weight: bold;">
			用户：{{user.name}}
		</view>
		<view class="container">
			<view v-for="(item,index) in doc" :key="item.doctor.did" class="doc"  :style="{'background-color':item.doctor.did == selectdoc ?'#daeada':'#fff'}"  @click="docselect(item.doctor.did)">
				<view >
					<view style="font-weight: bold;">
					{{item.doctor.dname}}
					</view>
					<view :style="{color:item.doctor.gender ==1?'blue':'pink',fontSize:'18px','font-weight': 'bold'}">
						{{item.doctor.gender ==1?'男':'女'}}
					</view>
					<view>
						{{item.doctor.jt}}
					</view>
				</view>
			</view>
		</view>
		<view class="container" style="margin-top: 2vh;">
			<view v-for="(item,index) in doc" :key="item.doctor.did" style="display: flex;flex-wrap: wrap;">
				<view v-for="(it,ind) in item.yycounts" :key="it.yyid" >
					<view v-if="selectdoc == item.doctor.did" style="display: flex; flex-wrap: wrap; align-items: center; justify-content: center;">
						<view class="people" :style="{'background-color':selecttime==it.yyid ?(it.people ==0?'#dfdfdf':'#ffffc7')  :(it.people ==0?'#dfdfdf':'#fff') }"  @click="timeselect(it.yyid)">
							<view>
								{{it.daytime}}{{it.infotime == 1?'上午':'下午'}}
							</view>
							<view :style="{color:it.people ==0 ?'#dd0000'  :'#000','font-weight': 'bold'}" >
								{{it.people}}人
							</view>
						</view>
						
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
				hid:0,
				hname:'',
				pmid:0,
				pname:'',
				docs:[],
				doc:[],
				selectdoc:0,
				selecttime:0,
				dis:false,
				user:''
				
			}
		},
		onLoad(options) {
			// console.log(options.hosselect);
			// console.log(options.pmselect);
			this.hid = options.hosselect;
			this.pmid = options.pmselect;
			this.user = uni.getStorageSync('user');
			this.getpmdoc();
			
		},
		methods: {
			yycom(){
				
				console.log('预约');
				let that = this;
				uni.request({
					url:'http://localhost:8080/finishyyps',
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
							that.docs = data.data;
							that.hname = that.docs.hname;
							that.pname = that.docs.pname;
							that.doc = that.docs.doc;
							uni.showToast({
								title:'没有名额请重试',
								icon:'error'
							})
						}else if(data.code == 403){
							that.docs = data.data;
							that.hname = that.docs.hname;
							that.pname = that.docs.pname;
							that.doc = that.docs.doc;
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
				for(var i=0;i<this.doc.length;i++){
					if(this.doc[i].doctor.did == this.selectdoc){
						for(var j=0;j<this.doc[i].yycounts.length;j++){
							if(this.doc[i].yycounts[j].yyid == this.selecttime){
								if(this.doc[i].yycounts[j].people ==0){
									this.dis = true;
									return;
								}
							}
						}
					}
				}
				this.dis = false;
			},
			docselect(index){
				this.selectdoc = index;
				this.selecttime =0;
				console.log(this.selectdoc);
				
			},
			getpmdoc(){
				let that =this;
				uni.request({
					url:'http://localhost:8080/getpmdoc',
					method:'POST',
					data:{
						'hid':this.hid,
						'pmid':this.pmid
					},
					success: (response) => {
						const data = response.data;
						if(data.code ==200){
							that.docs = data.data;
							that.hname = that.docs.hname;
							that.pname = that.docs.pname;
							that.doc = that.docs.doc;
							console.log(that.doc);
							that.selectdoc = that.doc[0].doctor.did;
							console.log();
							
						}else{
							uni.showLoading({
								mask:true,
								title:'加载中'
							})
							setTimeout(()=>{
								uni.hideLoading();
								uni.showToast({
									title:'服务器错误',
									icon:'error'
								})
							},1000)
						}
					},
					fail: (error) => {
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
	.doc{
		border-radius: 3vw; 
		margin-left: 3vw;
		margin-right: 3vw;
		margin-top: 1vh;
		width: 27vw;
		text-align: center;
		border: 2px solid #e2fffb;
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
