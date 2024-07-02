<template>
	<view>
		<view style="display: flex; align-items: center; padding: 2vh 5vw; border-bottom: solid 2px #cccc; background-color: rgba(255, 255, 255, 0.1);">
			<view style="width: 100px; height: 100px; border-radius:20px; background-color: #fff;display: flex;justify-content: center;align-items: center;">
				<view v-if="!flag"  style="width: 90px; height: 90px; background-color: #ccc; border-radius: 45px;" @click="login">
					<uni-icons type="person-filled" color="#fff" size="90"></uni-icons>
				</view>
				<view v-if="flag" style="width: 90px; height: 90px; background-color: #ccc; border-radius: 45px; display: flex; justify-content: center; align-items: center;">
					<view style="font-size: 45px; color: #fff;">{{user.name.substring(0,1)}}</view>
				</view>
			</view>
			<view style="padding-left: 3vw;">
				<view v-if="!flag" style="font-size: 25px; color: #000; font-weight: bold;" @click="login">点击注册/登录</view>
				<view v-if="flag" style="font-size: 25px; color: #000; font-weight: bold;">
					{{user.name}}
				</view>
				<view style="color: #000;">欢迎使用预约服务系统</view>
			</view>
		</view>
		<view style="display: flex; align-items: center; padding: 1vh 8vw; border-top: 5px #ccc solid;border-bottom: 5px #ccc solid; background-color: #fff;"  @click="service">
			<uni-icons type="list" size="28" color="#a2d2fc"></uni-icons>
			<view style="font-size: 23px; color: #999999; text-align: center; padding-left: 5vw;">
				预约管理记录
			</view>
		</view>
		<view style="display: flex; align-items: center; padding: 1vh 8vw; border-bottom: 5px #ccc solid; background-color: #fff;"  @click="info">
			<uni-icons type="person-filled" size="28" color="#a2d2fc"></uni-icons>
			<view style="font-size: 23px; color: #999999; text-align: center; padding-left: 5vw;">
				个人信息
			</view>
		</view>
		<view style="display: flex; align-items: center; padding: 1vh 8vw; border-bottom: 5px #ccc solid; background-color: #fff;"  @click="credit">
			<uni-icons type="starhalf" size="28" color="#a2d2fc"></uni-icons>
			<view style="font-size: 23px; color: #999999; text-align: center; padding-left: 5vw;">
				信用管理
			</view>
		</view>
		<view style="display: flex; align-items: center; padding: 1vh 8vw; border-bottom: 5px #ccc solid; background-color: #fff;">
			<uni-icons type="more-filled" size="28" color="#a2d2fc"></uni-icons>
			<view style="font-size: 23px; color: #999999; text-align: center; padding-left: 5vw;">
				更多功能待更新...
			</view>
		</view>
		<view v-if="flag"  style="display: flex; align-items: center; padding: 1vh 8vw; border-bottom: 5px #ccc solid; background-color: #fff;" @click="exit">
			<uni-icons type="paperplane-filled" size="28" color="#a2d2fc"></uni-icons>
			<view style="font-size: 23px; color: #999999; text-align: center; padding-left: 5vw;">
				退出登录
			</view>
		</view>
	</view>
</template>
<script>
	export default{
		data(){
			return {
				flag:false,
				user:{
					uid:'',
					name:'',
					score:'',
					sex:'',
					ph:'',
					iden:''
				}	
			}
		},
		onLoad() {
			let user = uni.getStorageSync('user');
			if(user){
				this.flag = true;
				this.user.uid = user.uid;
				this.user.name = user.name;
				this.user.score = user.score;
				this.user.sex = user.sex;
				this.user.ph = user.ph;
				this.user.iden = user.iden;
			}
		},
		methods: {
			login(){
				if(!this.flag){
					uni.navigateTo({
						url:'Login'
					})
				}
			},
			exit(){
				this.flag = false;
				uni.removeStorageSync('user');
				for (let key in this.user) {
					if (this.user.hasOwnProperty(key)) {
						this.user[key] = '';
					}
				}
			},
			service(){
				if(!this.flag){
					this.login();
				}
				else{
					uni.navigateTo({
						url:'record'
					})
				}
			},
			info(){
				if(!this.flag){
					this.login();
				}
				else{
					uni.navigateTo({
						url:'info?info='+JSON.stringify(this.user)
					})
				}
			},
			credit(){
				if(!this.flag){
					this.login();
				}
				else{
					uni.navigateTo({
						url:'credit'
					})
				}
			}
			
			
			
		}
	}
</script>



<style>
	.button{
		margin-top: 15px;
		width: 70%;
		border-radius: 18px;
	}
	.container{
		/* 定义flex容器 */
		display: flex;
		/*设置容器内部容器的排列方向*/	
		flex-direction: row; 
	}
	.info{
		width: 100vw;
		padding: 5% 0;
		background-color: #fff;
		border-top-left-radius: 5vw;
		border-top-right-radius: 5vw;
	}
</style>