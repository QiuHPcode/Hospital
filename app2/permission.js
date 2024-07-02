
// 页面白名单
const whiteList = [
	'/',
	'/src/components/index',
	'/src/components/Repair',
	'Login',
	'register',
	'Hosindex'
]

function hasPermission (url) {
	let user = uni.getStorageSync('user')
	// 在白名单中或有token，直接跳转
	let path = url.split('?')[0];
	if(whiteList.indexOf(path) != -1 || user) {
		console.log(whiteList.indexOf(path));
		return true
	}
	return false
}

uni.addInterceptor('navigateTo', {
	
	// 页面跳转前进行拦截, invoke根据返回值进行判断是否继续执行跳转
	invoke (e) {
		console.log('nav');
		if(!hasPermission(e.url)){
			uni.showToast({
				title:'请先登录',
				icon:'error'
			})
			setTimeout(()=>{
				uni.switchTab({
					url: '/src/components/index'
				})
			},500)
			
			return false
		}
		return true
	},
	success (e) {
		// console.log(e)
	}
})

// uni.addInterceptor('switchTab', {
// 	// tabbar页面跳转前进行拦截
// 	invoke (e) {
// 		console.log('sw');
// 		console.log(e)
// 		if(!hasPermission(e.url)){
// 			uni.showToast({
// 				title:'请先登录',
// 				icon:'error'
// 			})
// 			uni.switchTab({
// 				url: '/src/components/index'
// 			})
// 			return false
// 		}
// 		return true
// 	},
// 	success (e) {
// 		// console.log(e)
// 	}
// })