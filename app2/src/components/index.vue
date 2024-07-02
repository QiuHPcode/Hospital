<template >
	<view  >
		<view class="container" v-if="selectindex == 0">		
			<view v-for="(item,index) in hyq" :key="item.hid" style="width: 46vw; height: 49vw;  background-color: #fff; margin-top: 1vh;  border-radius: 5px;margin-left: 2vw;margin-right: 2vw; display: flex; flex-direction: column;align-items: center;" @click="hosinfo(index)">
				<image :src="item.hpo" mode="scaleToFill" style="width: 95%; height: 50%; margin-top: 2%;"></image>
				<view style="margin-top: 2%; width: 95%; font-size: 30rpx;white-space: nowrap;  overflow: hidden; text-overflow: ellipsis; text-align: center; font-weight: bold;">
					{{item.hname}}
				</view>
				<view style="margin-top: 5%; width: 95%; font-size: 30rpx; overflow: hidden; text-overflow: ellipsis; ">
					<span style="color: #a2d2fc;">*地址：</span>
					{{item.hloc}}
				</view>
			</view>
		</view>
		<view v-if="selectindex == 1">
			<view class="container1" >
				<view @click="selecthos(item.hid)" v-for="(item,index) in pm" :key="item.hid" class="hos" :style="{'background-color': hosselect==item.hid?'#a2d2fc':'#fff'}">
					<view style="font-weight: bold;">{{item.hname}}</view>	
				</view>
				
			</view>
			<view style="margin-left: 3vw;margin-right: 3vw; margin-top: 3vh;">
				<view style="font-size: 40rpx; font-weight: bold;">
					科室：
				</view>
				<view v-for="(item,index) in pm" :key="item.hid" style="display: flex;flex-wrap: wrap;">
					<view @click="selectpm(it.pmid)" :style="{'background-color': pmselect==it.pmid? '#9de1d4':'#fff',color: pmselect == it.pmid? '#fff' :'#000' }" class="pm" v-for="(it,ind) in item.partments" :key="it.pmid" v-if="hosselect == item.hid">
						{{it.pname}}
					</view>	
				</view>
			</view>
			<view style="margin-top: 5vh;  display: flex; justify-content: center; align-items: center;">
				<button  @click="pmyy()" type="default" :disabled="pmselect ==0" style="font-weight: bold; border:2px solid #e8eee8 ; width: 60vw; border-radius: 20vw;"> {{pmselect==0?'选择部门后预约':'开始预约'}} </button>
			</view>
			
		</view>
		
		<view v-if="selectindex == 2" >
			<view style="display: flex; align-items: center; ">
				<uni-search-bar style="width: 80vw;" v-model="searchValue"  clearButton="auto" cancelButton="none" radius="100" placeholder="搜索医生" />
				<button style="width: 15vw; margin-left: auto; border-radius: 10vw; height: 35px; font-size: 14px;" @click="search(searchValue)">搜索</button>
			</view>
			
			<view class="container2">
				<view @click="doyy(item.did)" v-for="(item,index) in docdis" :key="item.did" style="width: 46vw;  background-color: #fff; margin-top: 1vh;  border-radius: 5px;margin-left: 2vw;margin-right: 2vw; display: flex; flex-direction: column;align-items: center;" >
					
					<view style="display: flex; justify-content: center; align-items: center; background-color: #fff; width: 22vw; height: 22vw; border-radius: 11vw; border: 2px solid #e2e2e2; margin-top: 1vh;">
						<image :src="item.sex==1?'../../static/man.png':'../../static/woman.png'" mode="scaleToFill" style="width: 20vw; height: 20vw; margin-top: 2%;"></image>
					</view>
					<view style="margin-top: 1vw;font-weight: bold;">
						{{item.dname}}
					</view>
					<view >
						{{item.hname}}
					</view>
					<view>
						{{item.pname}}
					</view>
					<view>{{item.jt}}</view>
					<view>医生特长</view>
					<view style="font-size:12px;">
						{{item.specialty}}
					</view>
				</view>
			</view>
		</view>
		
		<uni-fab ref="fab"  horizontal="right" vertical="bottom" direction="horizontal" :pattern="pattern" :content="content" @trigger="trigger"/>
	</view>
</template>

<script>
	import { pathToBase64, base64ToPath } from '../../js_sdk/mmmm-image-tools/index.js'
	export default{
		data () {
			return {
				flag:true,
				selectindex:0,
				pattern:{
					color: '#2d2f31',
					backgroundColor: '#fff',
					selectedColor: '#a2d2fc',
					buttonColor: '#a2d2fc',
					iconColor: '#fff'
				},
				
				category:['院区','科室','医生','日期'],
				content: [
				{
					iconPath: '/static/bar/院区.png',
					selectedIconPath: '/static/bar/院区1.png',
					text: '院区显示',
					active: true
				},
				{
					iconPath: '/static/bar/科室.png',
					selectedIconPath: '/static/bar/科室1.png',
					text: '按科室',
					active: false
				},
				{
					iconPath: '/static/bar/医生.png',
					selectedIconPath: '/static/bar/医生1.png',
					text: '按医生',
					active: false
				}
				],
				hyq:[],
				pm:[],
				doc:[],
				docdis:[],
				hosselect: 0,
				pmselect:0,
				searchValue:''
			}
		},
		onLoad() {
			if(this.selectindex ==0 && this.hyq.length ==0){
				this.gethyq();
				
			}
			
			
		},
		//autoBackButton：false  无效的 可以在需要去除导航返回的那个页面 mounted 钩子里加上如下代码段
		mounted(){
			var a = document.getElementsByClassName('uni-page-head-hd')[0]
			a.style.display = 'none';
			
		},

		methods: {
			search(value){
				console.log(value);
				if(value!=''){
					this.docdis =[];
					for(var i =0; i<this.doc.length;i++){
						if(this.doc[i].dname.indexOf(value)>=0){
							this.docdis.push(this.doc[i]);
						}
					}
					
				}
				else{
					this.docdis = this.doc;
				}
				
			},
			doyy(index){
				console.log(index);
				for(var i=0;i<this.doc.length;i++){
					if(this.doc[i].did==index){
						let doc = JSON.stringify(this.doc[i]);
						uni.navigateTo({
							url:'doyy?doc='+doc
						})
						return;
					}
				}
				console.log('医生预约');
				
			},
			pmyy(){
				console.log('部门预约');
				console.log(this.hosselect);
				console.log(this.pmselect);
				uni.navigateTo({
					url:'pmyy?hosselect='+this.hosselect+'&&pmselect='+this.pmselect
				})
			},
			selectpm(index){
				this.pmselect = index;
			},
			selecthos(index){
				this.hosselect = index;
				this.pmselect =0;
			},
			hosinfo(index){
				let info = JSON.stringify(this.hyq[index]);
				uni.navigateTo({
					url:'Hosindex?info='+info
				})
			},
			selecttrigger(index){
				if(index ==0 && this.hyq.length == 0){
					this.gethyq();
				}
				if(index == 1 && this.pm.length == 0){
					this.getpm();
				}
				if(index == 2 && this.doc.length == 0){
					this.getdoc();
				}
				
			},
			getpm(){
				let that = this;
				uni.request({
					url:'http://localhost:8080/allpm',
					method:'GET',
					success: (response) => {
						const data = response.data;
						if(data.code ==200){
							that.pm = data.data;
							console.log(that.pm);
							that.hosselect = that.pm[0].hid;
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
				console.log('请求科室');
			},
			getdoc(){
				console.log('请求医生');
				let that = this;
				uni.request({
					url:'http://localhost:8080/alldoc',
					method:'GET',
					success: (response) => {
						const data = response.data;
						if (data.code == 200){
							that.doc = data.data;
							that.docdis = that.doc;
							
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
			},
			
			gethyq(){
				let that = this;
				uni.request({
					url:'http://localhost:8080/hyq',
					method:'GET',
					success: (response) => {
						const data = response.data;
						if(data.code == 200){
							// console.log(data.data);
							that.hyq = data.data;
							for(let i =0;i<that.hyq.length;i++){
								that.hyq[i].hpo = "data:image/jpeg;base64,"+that.hyq[i].hpo;
								
								base64ToPath(that.hyq[i].hpo).then(path =>{						
									that.hyq[i].hpo = path;
									// console.log('成功转换');
									// console.log(that.hyq[i].hpo);
								})
								.catch(error =>{
									
								})
							}
							// console.log(that.hyq);
							
						}
						else{
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
			},
			trigger(e){
				this.content[this.selectindex].active = false;
				this.selectindex=e.index;
				this.selecttrigger(this.selectindex);
				this.content[e.index].active = !e.item.active;
				
			}
			
		}
	}
</script>



<style>
	
	.container {
	  display: flex;
	  flex-wrap: wrap;
	  /* justify-content: space-between;*/ /* 使两列之间有间距 */ 

	}
	.container1 {
	  display: flex;
	  flex-wrap: wrap;
	  justify-content: space-between; /* 使两列之间有间距*/
	  margin-left: 3vw;
	  margin-right: 3vw;
	}
	.container2 {
	  display: flex;
	  flex-wrap: wrap;
	  margin-top: 2vh;
	  /* justify-content: space-between;*/ /* 使两列之间有间距 */ 
	
	}
	.hos{
		border: 2px solid #fff; 
		border-radius: 10px; 
		margin-top: 3vh; 
		height: 30px; 
		width: 45vw; 
		/* background-color: #a2d2fc; */
		text-align: center; 
		display: flex; 
		justify-content: center; 
		align-items: center;
	}
	
	.pm{
		border-radius: 5vw; 
		text-align: center; 
		margin-top: 1vh; 
		border: 2px solid #fff;
		width: 28vw;
		margin-left: 1vw; 
		margin-right: 1vw;
	}
</style>