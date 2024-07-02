<template>
	<view :style="{height: screenHeight+'px'}">
		<view style="padding-top: 30%;">
			<uni-group mode="card" >
				<uni-forms ref="baseForm">
					<view style="display: flex; justify-content: center; align-items: center;">
						<text style="font-size: 30px; color: #999999;">注 册</text>
					</view>
					<uni-icons type="person" size="100" class="person"></uni-icons>
				  	<uni-forms-item label="账号" required>
				  		<uni-easyinput  placeholder="请输入账号" v-model="form.ph" />
				  	</uni-forms-item>
					<uni-forms-item label="密码" required>
						<uni-easyinput type="password" placeholder="请输入密码" v-model="form.pw"/>
					</uni-forms-item>
					<uni-forms-item label="确认密码" required>
						<uni-easyinput type="password" placeholder="请确认密码" v-model="ppw"/>
					</uni-forms-item>
					<uni-forms-item label="姓名" required>
						<uni-easyinput  placeholder="请输入姓名" v-model="form.name"/>
					</uni-forms-item>
					<uni-forms-item label="性别" required>
						<radio-group @change="radioChange"style="display: flex; align-items: center;">
							<label  v-for="(item, index) in sex" :key="item.value" >
								
									<view style="margin-top: 6px; margin-right: 10vw;">
										<radio :value="item.value" :checked="item.checked" >{{item.label}}</radio>
									</view>
							</label>
						</radio-group>
					</uni-forms-item>
					<uni-forms-item label="身份证号" required>
						<uni-easyinput  placeholder="请输入身份证号" v-model="form.iden"/>
					</uni-forms-item>
					<button type="primary"  style="width:70%;border-radius: 20px;" @click="register">注册</button>
				</uni-forms>
			</uni-group>
		</view>
	
	</view>
</template>

<script>
	export default {
		data() {
			return {
				screenHeight:0,
				form:{
					ph:'',
					pw:'',
					name:'',
					sex: 1,
					iden: ''
				},
				ppw:'',
				sex:[{
					label: "男",
					value: "1",
					checked: true
				},{
					 label: "女",
					 value: "2"
					 
				}]
				
			}
		},
		onLoad() {
			this.screenHeight = uni.getSystemInfoSync().windowHeight;
			console.log('高度2',this.screenHeight);
		},
		
		methods: {
			radioChange(e){
				 this.form.sex = parseInt(e.detail.value);
			},
			register(){
				console.log(this.form);
				if(!this.form.ph || !this.form.iden || !this.form.name || !this.form
				.pw || !this.ppw ){
					uni.showToast({
						icon:'error',
						title:'输入不能为空'
					})
					return;
				}
				
				if (this.form.pw != this.ppw) {
					uni.showToast({
						icon: 'error',
						title: '密码不一致'
					});
					return;
				}
				uni.request({
					url:'http://localhost:8080/user/register',
					method:'POST',
					data:this.form,
					success:(response) => {
						const data = response.data
						console.log(data)
						if(data.code == 200){
							uni.showToast({
								icon:'success',
								title:'注册成功'
							});
							setTimeout(()=>{
								uni.reLaunch({
									url:'./Login'
								});
							},500);
							// uni.reLaunch({
							// 	url:'./index'
							// });
						} else if (data.code == 404){
							if(data.msg =='100'){
								uni.showToast({
									icon:'error',
									title:'手机号已注册'
								})
							}else if(data.msg =='200'){
								uni.showToast({
									icon:'error',
									title:'身份已被注册'
								})
							}
							else{
								uni.showToast({
									icon:'error',
									title:'注册失败'
								});
							}
							
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
					}
				})
				
				
			}
		}
	}
</script>

<style lang="scss">
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
	/deep/.uni-forms-item {
		&__label{
			padding: 0 0 0 0 ;
		}
	}
</style>
