<template>
	<view :style="{height: screenHeight+'px'}">
		<view style="padding-top: 30%;">
			<uni-group mode="card" >
				<uni-forms ref="baseForm">
					<view style="display: flex; justify-content: center; align-items: center;">
						<text style="font-size: 30px; color: #999999;">登 录</text>
					</view>
					<uni-icons type="person" size="100" class="person"></uni-icons>
				  	<uni-forms-item label="账号" required>
				  		<uni-easyinput v-model="form.ph" placeholder="请输入账号" />
				  	</uni-forms-item>
					<uni-forms-item label="密码" required>
						<uni-easyinput v-model="form.pw" type="password" placeholder="请输入密码" />
					</uni-forms-item>
					<view class="register">
						<view style="color: #999999;"> 
						<navigator url="register" >前往注册</navigator>
							
						</view>
					</view>
					<button type="primary" @click="userlogin" style="width:70%;border-radius: 20px;">登 录</button>
				</uni-forms>
			</uni-group>
		</view>

	</view>
</template>



<script>
import axios from 'axios'
export default {
    data() {
        return {
			form : {
				ph: '',
				pw: ''
			},
			flag:'True',
			screenHeight:0
        }
    },
	onLoad() {

		this.screenHeight = uni.getSystemInfoSync().windowHeight;
		console.log('高度2',this.screenHeight);
		
	},
    methods: {
        userlogin () {
            uni.request({
				url:'http://localhost:8080/user/login',
				method:'POST',
				// header: {  
				//     'Content-Type': 'application/x-www-form-urlencoded'  
				// },  
				data:this.form,
				success:(response) => {
					const data = response.data
					console.log(data)
					if(data.code == 200){
						uni.showToast({
							icon:'success',
							title:'登陆成功'
						});
						uni.setStorage({
							key:'user',
							data:data.data
						})
						setTimeout(()=>{
							uni.reLaunch({
								url:'./index'
							});
						},500);
						// uni.reLaunch({
						// 	url:'./index'
						// });
					} else if (data.code == 404){
						uni.showToast({
							icon:'error',
							title:'账号或密码错误'
						});
					} else {
						uni.showToast({
							icon:'error',
							title:'服务器错误'
						});
					}
				},
				fail:(error) => {
				    uni.showToast({
				    	icon:'error',
				    	title:'服务器错误'
				    });
				},
			})
            
        },

    }
}
</script>



<style>
	.logo{
		width: 300rpx;
		height: 300rpx;
		margin-left: auto; 
		margin-right:auto; 
	}
	.person{
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	.register{
		display: flex;
		justify-content: flex-end;
		align-items: center;
		padding-bottom: 5%;
		padding-right: 5vw;
	}
</style>