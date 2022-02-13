# car-booking-api
Assignment for Prudential

启动步骤：
1. 创建数据库，运行 sql/car_booking.sql 文件；
2. 修改 src/main/resources/application.properties 中的数据库配置；
3. 启动程序；
4. 可以访问 http://localhost:8080/swagger-ui.html# 测试；
5. 可以运行单元测试 src/test/java/com/yuanjingjing/carbooking/TestCarBooking.java 测试。

API design
仅支持按天、连续租车，不考虑取车地点时间等信息
1. GET /models 查询所有车辆及可预订时间
   入参：查询天数（默认为未来七天）days
   出参：model信息，查询天数列表（仅返回每种车型的总库存 stock 及每天已预订的数量）
   [
   {
   "id": 1,
   "modelName": "BMW 650",
   "stock": 2,
   "dateMap": {}
   },
   {
   "id": 2,
   "modelName": "Toyota Camry",
   "stock": 2,
   "dateMap": {
   "2022-02-15": 1,
   "2022-02-14": 2,
   "2022-02-18": 2
   }
   }
   ]

2. POST /booking 预订车辆
   说明：校验日期有效性，校验是否已无库存
   入参：
   {
   "modelId": 2,
   "startDate": "2022-02-15"
   "endDate": "2022-02-15",
   }
   出参： 
   { 
   "msg": "Already booked!", 
   "code": 500//0为成功，非0为失败 
   } 
