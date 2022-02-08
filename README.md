# car-booking-api
Assignment for Prudential

API design
仅支持按天、连续租车，不考虑取车地点时间等信息
1. 查询所有车辆及可预订时间
   入参：model（模糊）、查询天数（默认为未来七天）
   出参：model信息，查询天数列表（每天可预定的数量）
2. 预订车辆
