<template>
	<view >
		<view class="container" >
			<view style="width: 48vw; margin-left: 1vw;margin-top: 1vh;">
				<view style="font-size: 35rpx; font-weight: bold;">
					{{info.hname}}
				</view>
				<view style="display: flex;margin-top: 2vh; width: 48vw;flex-wrap: wrap; text-overflow: clip;">
					<view style="color: #999999; ">*地址:</view>
					<view style="width: 48vw; word-wrap: break-word;">{{info.hloc}}</view>
				</view>
				
			</view>
			<view style="width: 48vw; height: 48vw;margin-right: 1vw;margin-top: 1vh;">
				<image :src="info.hpo" mode="scaleToFill" style="width: 100%; height: 100%;" ></image>
				
			</view>
		</view>
		<view style="margin-top: 1vh;margin-left: 1vw;margin-right: 1vw;">
			<view style="color: #e1e1e1; font-size: 35rpx; font-weight: bold;">
				简介：
			</view>
			<view style="word-wrap: break-word;">
				{{info.info}}
			</view>
		</view>
		<view style="margin-top: 1vh;margin-left: 1vw;margin-right: 1vw;">
			<view style="color: #787878; font-size: 35rpx; font-weight: bold;">
				设施情况：
			</view>
			<view style="word-wrap: break-word;">
				{{info.device}}
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				info:[]
			}
		},
		onLoad(options) {
			this.info = JSON.parse(options.info);
		},
		methods: {
			
		}
	}
</script>

<style>


	.container {
	  display: flex;
	  flex-wrap: wrap;
	  justify-content: space-between; /* 使两列之间有间距 */
	  background-color: rgba(255, 255, 255, 0.1);
	  
	}
	
</style>
