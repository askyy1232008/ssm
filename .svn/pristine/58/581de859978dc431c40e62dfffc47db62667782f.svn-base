package test.SpringMVC;

import com.openapi.sdk.service.DataExchangeService;
import com.openapi.sdk.service.TransCode;

/***
 * 使用SDK接口客户端调用示例（如不使用SDK，可通过标准HTTPS方式调用接口，忽略正式信任。
 * 数据加密方式为标准DES加密，模式：DES/CBC/PKCS5Padding,密码：CTFOTRV1,编码格式UTF-8） 该文件使用UTF-8编码格式
 */

public class OpenAPITest {

	/**
	 * 用户登陆 用户首次调用接口，须先登录，认证通过后生成令牌。 令牌有效期默认为3天，登录后之前的令牌将立即失效，多服务调用业务接口时，建议由统一服
	 * 务调用登录接口将令牌缓存起来，多个服务统一从共享缓存中获取令牌。
	 * 令牌失效后再调用登录接口获取令牌，避免频繁调用登录接口，建议一天内登录次数不超过10 次，超过10次将触发安全系统报警。
	 */
	private static String OPENAPI_NAME= "2564ec08-f850-4b4a-af60-59e11a501f53";
	private static String OPENAPI_PWD= "b7631027Y094755LZaZ55t5e5X1cmQ";
	private static String OPENAPI_CLIENT_ID = "85fd3805-3350-47b6-a284-f99b5b26ecbd";
	
	private static String TEST_OPENAPI_NAME= "771946bb-5989-4492-9037-56c837e04aef";
	private static String TEST_OPENAPI_PWD= "hQ8l3O4c4L3PI9Iuu73r337T4QegV0";
	private static String TEST_OPENAPI_CLIENT_ID = "6f258f2a-6c89-42a1-9320-9bdb3ac22bf6";
	
	private static String ZHENGSHI = "https://zhiyunopenapi.95155.com";
	private static String CESHI = "https://testopen.95155.com";
	
	public static String login() {
		try {
			String p = "user="+TEST_OPENAPI_NAME+"&pwd="+TEST_OPENAPI_PWD;
			System.out.println("参数:" + p);
			p = TransCode.encode(p);
			String url = CESHI + "/apis/login/" + p + "?client_id="+TEST_OPENAPI_CLIENT_ID;
			DataExchangeService des = new DataExchangeService(5000, 5000);
			System.out.println("请求地址:" + url);
			String res = des.accessHttps(url, "POST");
			System.out.println("返回:" + res);
			return res;
		} catch (Exception e) {
			System.out.println("e:" + e.getMessage());
		}
		return null;
	}

	/**
	 * 一、 车辆最新位置查询（车牌号）接口 本接口提供指定车牌号的车辆最新位置查询。
	 */
	public static void vLastLocation(String token,String LicensePlate) {
		try {
			String p = "token="+token+"&vclN="+LicensePlate+"&timeNearby=30";//陕YH0009
			System.out.println("参数:" + p);
			p = TransCode.encode(p);
			String url = CESHI +"/apis/vLastLocation/" + p + "?client_id="+TEST_OPENAPI_CLIENT_ID;
			DataExchangeService des = new DataExchangeService(5000, 5000);
			System.out.println("请求地址:" + url);
			String res = des.accessHttps(url, "POST");
			System.out.println("返回:" + res);
		} catch (Exception e) {
			System.out.println("e:" + e.getMessage());
		}
	}
	
	/**
	 * 通过车牌查询车辆轨迹
	 * @param token  令牌
	 * @param LicensePlate  车牌号
	 * @param startTime  开始时间
	 * @param endTime  结束时间
	 * @return
	 */
	public static String vHisTrack24(String token,String LicensePlate,String startTime,String endTime){
		try {
			String p = "token="+token+"&vclN="+LicensePlate+"&qryBtm="+startTime+"&qryEtm="+endTime;
			System.out.println("参数:" + p);
			p = TransCode.encode(p);
			String url = CESHI +"/apis/vHisTrack24/" + p + "?client_id="+TEST_OPENAPI_CLIENT_ID;
			DataExchangeService des = new DataExchangeService(5000, 5000);
			System.out.println("请求地址:" + url);
			String res = TransCode.decode(des.accessHttps(url, "POST"));
			System.out.println("返回:" + res);
			return res;
		} catch (Exception e) {
			System.out.println("e:" + e.getMessage());
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
//		String result = OpenAPITest.login();
		//返回:{"result":"aa434f2c-8f21-48ef-bb53-638cb0aa0cd8","status":1001}   2019-03-14 16:20 - 2019-03-17 16:20   正式
		//返回:{"result":"e1668e55-8ed8-4a91-adf3-4c5e1fe8fd58","status":1001}   2019-03-14 16:48 - 2019-03-17 16:48  测试
		OpenAPITest.vHisTrack24("e1668e55-8ed8-4a91-adf3-4c5e1fe8fd58","陕YH0009","2018-12-18 01:00:00","2018-12-18 01:59:59");
	}
	
	/**
	 * status 返回
	 * @param status
	 */
	public static String errorMsg(String status){
		switch (status) {
		case "1001":
			return "接口执行成功";
		case "1002":
			return "参数不正确（参数为空、查询时间范围不正确、参数数量不正确）";
		case "1003":
			return "车辆调用数量已达上限";
		case "1004":
			return "接口调用次数已达上限";
		case "1005":
			return "该 API 账号未授权指定所属行政区划数据范围";
		case "1006":
			return "无结果";
		case "1010":
			return "用户名或密码不正确";
		case "1011":
			return "IP 不在白名单列表";
		case "1012":
			return "账号已禁用";
		case "1013":
			return "账号已过有效期";
		case "1014":
			return "无接口权限";
		case "1015":
			return "用户认证系统已升级，请使用令牌访问";
		case "1016":
			return "令牌失效";
		case "1017":
			return "账号欠费";
		case "1018":
			return "授权的接口已禁用";
		case "1019":
			return "授权的接口已过期";
		case "1020":
			return "该车调用次数已达上限";
		case "1021":
			return "client_id 不正确";
		case "9001":
			return "系统异常";
		default:
			return null;
		}
	}
}
