<template>
	<view>
		<view style="display: flex; justify-content: center; align-items: center; color: #000; font-size: 30px; font-weight: bold;">
			信用度:{{score}}
		</view>
		<view ref="waterball" :style="{width: screenWidth+'px',height: screenHeight+'px'}">
		</view>
		<view style="display: flex; align-items: center;justify-content: center;">
			<text :style="{'font-size':'40rpx',color: color[index] ,fontWeight:'bold'} ">{{text[index]}}</text>
		</view>
		<view v-if="flag" style="margin-top: 1vh; ">
			<view style="margin-left: 2vw; font-size: 38rpx; font-weight: bold;">违约记录：</view>
			<view :style="{overflow: 'auto', height: height-360+'px'}">
				<view v-for="(item,index) in credit.list" :key="index" style="border-radius: 5px; margin:0.3vh 2vw;padding-left: 2vw; display:  block; background-color: #fff; border: solid 2px #000;">
					<view style="display: flex;">
						<view style="font-weight: bold;">
							时间：
						</view>
						<view>
							{{item.daytime}}{{item.infotime==1?'上午':'下午'}}
						</view>
					</view>
					<view style="display: flex;">
						<view style="font-weight: bold;">
							医院：
						</view>
						<view>
							{{item.hname}}
						</view>
						
					</view>
					<view style="display: flex;">
						<view style="font-weight: bold;">
							科室：
						</view>
						<view>
							{{item.pname}}
						</view>
						
					</view>
					<view style="display: flex; flex-wrap: wrap;">
						<view style="font-weight: bold;">
							医生：
						</view>
						<view>
							{{item.dname}} 
						</view>
						<view style="font-weight: bold; margin-left: 2vw;">
							职称：
						</view>
						<view>
							{{item.jt}}  
						</view>
					</view>
					<view style="display: flex;flex-wrap: wrap;">
						<view style="font-weight: bold;">
							惩罚：
						</view>
						<view>
							{{item.sc}}信用度
						</view>
					</view>
				</view>
			</view>
		</view>
		<view v-if="!flag" style="margin-top: 1vh; display: flex; justify-content: center;">
			<view style=" font-size: 38rpx; font-weight: bold;">暂无违约记录！</view>
		</view>
	</view>
</template>

<script>
	
	export default {
		data() {
			return {
				score: 100,
				screenHeight:250,
				screenWidth:400,
				height:800,
				index:0,
				text:['当前信用度很好,请继续保持','当前信用度及格,请谨慎预约','当前信用度较差,可能会受到暂时封禁!'],
				color:['#FFFFE0','#54FF9F','#FF0000'],
				flag:true,
				credit:[12,21,0,3,115,41,16,594],
				myChart:null
			}
		},
		onLoad() {
			
			this.screenWidth = uni.getSystemInfoSync().windowWidth;
			console.log(this.screenWidth);
			this.height = uni.getSystemInfoSync().windowHeight;
			this.getcredit();
			
		},
		mounted() {
			// console.log(this.screenWidth,this.screenHeight);
			
			if(this.score>=75){
				this.index =0;
			}else if(this.score>=60 && this.score<75){
				this.index =1;
			}else{
				this.index =2;
			}
			
			
		},
		beforeDestroy() {
			this.disposeChart();
		},
		methods: {
			getcredit(){
				const user = uni.getStorageSync('user');
				let that = this;
				uni.request({
					url:'http://localhost:8080/getcredit',
					method:'POST',
					data:{
						'uid':user.uid
					},
					success: (response) => {
						const data = response.data;
						if(data.code == 200){
							that.credit = data.data;
							that.score = that.credit.score;
							that.createWater();
							if(that.credit.list.length ==0){
								that.flag = false;
							}
							console.log(that.credit);
						}else{
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
						
					},
					fail: (error) => {
						console.log(error);
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
				
			},
			disposeChart(){
				if (this.myChart){
					console.log('销毁');
					this.myChart.dispose();
					this.myChart = null;
				}
			},
			createWater() {	
			      this.myChart = this.$echarts.init(this.$refs.waterball.$el)
			      var option = {
			        series: [
			          {
			            name: 'water echart',
			            type: 'liquidFill',
			            radius: '200px',
			            data: [this.score/100,this.score/100*0.8,this.score/100*0.6],  
			            label: {  
			                color: '#27e5f1',
			                insideColor: '#fff',
							fontSize: 40,  // 此处设置为0时文字消失
							fontWeight: 'bold',
							formatter: function(param) {
								return (param.value * 100).toFixed(0);
							}
							
			            },
			            color: [
			              {
			                type: 'linear',
			                x: 0,
			                y: 1,
			                x2: 0,
			                y2: 0,
			                colorStops: [
			                  {
			                    offset: 1,
			                    color: ['#6a7feb'] // 0% 处的颜色
			                  },
			                  {
			                    offset: 0,
			                    color: ['#27e5f1'] // 100% 处的颜色
			                  }
			                ],
			                global: false // 缺省为 false
			              }
			            ],
			            outline: {
			              show: true,
			              borderDistance: 5,
			              itemStyle: {
			                borderColor: '#27e5f1',  // 水球图外边框的颜色
			                borderWidth: 3  // 水球图外边框的宽度
			              }
			            }
			          }
			        ]
			      }
			      this.myChart.setOption(option)
			    }
		}
	}
</script>

<style>

</style>
