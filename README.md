# 移动端患者预约服务

## Uni-app(Vue2)+SpringBoot+MyBatis
* Node.js版本 v18.18.2  
* Maven版本 v3.6.3  
* Spring版本 v3.1.12  
* Java jdk v1.8(Java8)
## 运行
### 后端(hos)
配置maven后直接启动就可以
### 前端(app2)
项目于HBuilderX导入
先进行npm install导入一下需求包(echarts等)后再运行
### 功能实现
#### 备注：此项目开发周期较短，没有做Web后台管理端，只实现了简单的预约服务，后端只调取从明天开始往后总共三天的预约资源供前端选择，实现了定时任务每天0点和12点检查是否有超时违约，为了简化时间段只设置了上午和下午，登录没有用token验证，数据库也没有加密，等后续有时间再进行补充，请谅解。

* 用户登录和注册
  
![未登录](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E6%9C%AA%E7%99%BB%E5%BD%95.png)
![登录](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E7%99%BB%E5%BD%95.png)
![注册](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E6%B3%A8%E5%86%8C.png)
![登录后](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E7%99%BB%E5%BD%95%E5%90%8E.png)

* 用户查看医院介绍
  
![医院](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E5%8C%BB%E9%99%A2.png)
![医院介绍](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D.png)

* 用户选择院区部门或医生进行预约服务
  
![科室](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E7%A7%91%E5%AE%A4.png)
![科室内](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E7%A7%91%E5%AE%A4%E5%86%85.png)

* 用户可查看自己的预约记录或进行取消
  
![预约记录](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E9%A2%84%E7%BA%A6%E8%AE%B0%E5%BD%95.png)
![取消预约](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E5%8F%96%E6%B6%88%E9%A2%84%E7%BA%A6.png)
![取消中](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E5%8F%96%E6%B6%88%E4%B8%AD.png)

* 用户可查看自己个人信息
  
![个人信息](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E4%B8%AA%E4%BA%BA%E4%BF%A1%E6%81%AF.png)

* 用户还可查看自己的信用值
  
![信用](https://github.com/QiuHPcode/picture/blob/master/%E5%8C%BB%E9%99%A2%E4%BB%8B%E7%BB%8D/%E4%BF%A1%E7%94%A8.png)

* 实现了定时任务 每天0点和12点进行一次检查是否有逾期未到违约自动扣除信用度  
