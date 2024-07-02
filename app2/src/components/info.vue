<template>
	<view :style="{height: screenHeight+'px'}">
		<view style="padding-top: 20%;">
			<uni-group mode="card" >
				<uni-forms ref="baseForm">
					<view style="display: flex;  align-items: center; justify-content: center;">
						<uni-icons type="person" size="100" color="#999"></uni-icons>
						
						
					</view>
				  	<uni-forms-item label="姓名:" required style=" display: flex; align-items: center; padding-left: 20vw;">
						<text style="text-align: center;">{{info.name}}</text>
						
				  	</uni-forms-item>
					<uni-forms-item label="性别:" required style=" display: flex; align-items: center; padding-left: 20vw;">
						<text style="text-align: center;">{{info.sex}}</text>
					</uni-forms-item>
					<uni-forms-item label="手机号:" required style=" display: flex; align-items: center; padding-left: 20vw;">
						<text style="text-align: center;">{{info.ph}}</text>
					</uni-forms-item>
					<uni-forms-item label="身份证号:" required style=" display: flex; align-items: center; padding-left: 20vw;">
						<text style="text-align: center;">{{info.iden}}</text>
					</uni-forms-item>
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
				info:{
					uid:'',
					name:'',
					score:'',
					sex:'',
					ph:'',
					iden:''
				}
				
			}
		},
		onLoad(options) {
			 if (options != null && options.info != null) {
				try {
					let info = JSON.parse(options.info);
					this.info.uid = info.uid;
					this.info.name = info.name;
					this.info.score = info.score;
					if(info.sex==1){
						this.info.sex = '男';
					}else{
						this.info.sex = '女';
					}
					this.info.ph = info.ph;
					this.info.iden = info.iden;
					// 处理解析后的info数据
				} catch (error) {
					console.error('Failed to parse JSON:', error);
				}
			} 
			this.screenHeight = uni.getSystemInfoSync().windowHeight;
			// console.log('高度2',this.screenHeight);
		
		},
		methods: {
			
		}
	}
</script>

<style lang="scss">
	/deep/.uni-forms-item {
		&__label{
			padding: 0 0 0 0 ;
		}
	}
</style>
