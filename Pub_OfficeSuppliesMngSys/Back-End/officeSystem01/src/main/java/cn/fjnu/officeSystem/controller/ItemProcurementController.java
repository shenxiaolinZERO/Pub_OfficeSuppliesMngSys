package cn.fjnu.officeSystem.controller;

import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjnu.officeSystem.entity.Item;
import cn.fjnu.officeSystem.entity.ItemProcurement;
import cn.fjnu.officeSystem.service.ItemProcurementService;
import net.sf.json.JSONObject;

@RequestMapping("/ItemProcurement")
public class ItemProcurementController {
	@Resource
	ItemProcurementService itemProcurementService;

	// 采购申请首页
	@RequestMapping(value = "/getItemProcurementApplyHome", produces = "application/json;charset=utf-8")
	public @ResponseBody String getItemProcurementApplyHome(@RequestBody String json, HttpServletResponse response)
			throws ParseException {
		try {
			json = URLDecoder.decode(json, "utf-8");
			if (json.endsWith("=")) {
				json = json.substring(0, json.length() - 1);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();

		}
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");
		int pageCount = jsonObject.optInt("pageCount");
		String staffId = jsonObject.optString("staffId");
		String itemTypeId = jsonObject.optString("itemTypeId");
		String itemName = jsonObject.optString("itemName");
		String itemId = jsonObject.optString("itemId");
		String preStartTimeStr = jsonObject.optString("preStartTimeStr");
		String preEndTimeStr = jsonObject.optString("preEndTimeStr");
		String applyTimeSort = jsonObject.optString("applyTimeSort");
		return itemProcurementService.getItemProcurementApplyHome(pageIndex, pageCount, staffId, itemTypeId, itemName,
				itemId, preStartTimeStr, preEndTimeStr, applyTimeSort);

	}

	// 不通过--填写预采购理由
	@RequestMapping(value = "/notPassItemProcurementApply", produces = "application/json;charset=utf-8")
	public @ResponseBody String notPassItemProcurementApply(@RequestBody String json, HttpServletResponse response) {
		try {
			json = URLDecoder.decode(json, "utf-8");
			if (json.endsWith("=")) {
				json = json.substring(0, json.length() - 1);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();

		}
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject jsonObject = JSONObject.fromObject(json);
		String applyId = jsonObject.optString("applyId");
		String staffId = jsonObject.optString("staffId");
		String reason = jsonObject.optString("reason");
		return itemProcurementService.notPassItemProcurementApply(applyId, staffId, reason);
	}

	// 确定预采购--将采购申请写入预采购清单
	@RequestMapping(value = "/confirmPreItemProcurement", produces = "application/json;charset=utf-8")
	public @ResponseBody String confirmPreItemProcurement(@RequestBody String json, HttpServletResponse response) {
		try {
			json = URLDecoder.decode(json, "utf-8");
			if (json.endsWith("=")) {
				json = json.substring(0, json.length() - 1);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();

		}
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject jsonObject=JSONObject.fromObject(json);
		String applyId=jsonObject.optString("applyId");
		String staffId=jsonObject.optString("staffId");
		return itemProcurementService.confirmPreItemProcurement(applyId, staffId);

	}

	// 历史预采购清单
	@RequestMapping(value = "/PreItemProcurementHome", produces = "application/json;charset=utf-8")
	public @ResponseBody String PreItemProcurementHome(@RequestBody String json, HttpServletResponse response)
			throws ParseException {
		try {
			json = URLDecoder.decode(json, "utf-8");
			if (json.endsWith("=")) {
				json = json.substring(0, json.length() - 1);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();

		}
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject jsonObject = JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");// 当前页
		int pageCount = jsonObject.optInt("pageCount");// 页大小
		String itemId = jsonObject.optString("itemId");
		String itemTypeId = jsonObject.optString("itemTypeId");
		String itemName = jsonObject.optString("itemName");
		String preStartTime = jsonObject.optString("preStartTime");
		String preEndTime = jsonObject.optString("preEndTime");
		String staffId = jsonObject.optString("staffId");
		String preTimeSort = jsonObject.optString("preTimeSort");
		String result = itemProcurementService.getPreItemProcurementHome(pageIndex, pageCount, staffId, itemTypeId,
				itemName, itemId, preTimeSort, preStartTime, preEndTime);
		return result;

	}

	// 点击采购、
	@RequestMapping(value = "/purchase", produces = "application/json;charset=utf-8")
	public @ResponseBody String purchase(@RequestBody String json, HttpServletResponse response) {
		try {
			json = URLDecoder.decode(json, "utf-8");
			if (json.endsWith("=")) {
				json = json.substring(0, json.length() - 1);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();

		}
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		// Item item, ItemProcurement itemProcurement
		JSONObject jsonObject=JSONObject.fromObject(json);
		Item item=(Item) JSONObject.toBean(jsonObject.fromObject("item"),Item.class);
		ItemProcurement itemProcurement=(ItemProcurement) JSONObject.toBean(jsonObject.fromObject("itemProcurement"),ItemProcurement.class);
		return itemProcurementService.purchase(item, itemProcurement);
	}

	// 待采购清单（物品采购表中未入库登记）
	@RequestMapping(value = "/getUnInStorageItemProcurement", produces = "application/json;charset=utf-8")
	public @ResponseBody String getUnInStorageItemProcurement(@RequestBody String json, HttpServletResponse response) {
		try {
			json = URLDecoder.decode(json, "utf-8");
			if (json.endsWith("=")) {
				json = json.substring(0, json.length() - 1);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();

		}
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject jsonObject=JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");// 当前页
		int pageCount = jsonObject.optInt("pageCount");// 页大小
		int timeSort=jsonObject.optInt("timeSort");
		ItemProcurement itemProcurement=(ItemProcurement) JSONObject.toBean(jsonObject.fromObject("itemProcurement"),ItemProcurement.class);
	    return itemProcurementService.getUnInStorageItemProcurement(itemProcurement, timeSort, pageCount, pageIndex);
	}

	// 已采购清单（物品采购表中已入库登记）
	@RequestMapping(value = "/getInStorageItemProcurement", produces = "application/json;charset=utf-8")
	public @ResponseBody String getInStorageItemProcurement(@RequestBody String json, HttpServletResponse response) {
		try {
			json = URLDecoder.decode(json, "utf-8");
			if (json.endsWith("=")) {
				json = json.substring(0, json.length() - 1);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();

		}
		// 跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject jsonObject=JSONObject.fromObject(json);
		int pageIndex = jsonObject.optInt("pageIndex");// 当前页
		int pageCount = jsonObject.optInt("pageCount");// 页大小
		int endTimeSort=jsonObject.optInt("endTimeSort");
		ItemProcurement itemProcurement=(ItemProcurement) JSONObject.toBean(jsonObject.fromObject("itemProcurement"),ItemProcurement.class);
		return itemProcurementService.getInStorageItemProcurement(itemProcurement, endTimeSort, pageCount, pageIndex);
	}

}
