package cn.qihaizhi.bank;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.qihaizhi.bank.responseEntities.PayResponseEntity;
/**
 * Payment transaction
 * @author qihaizhi
 */
@Controller
public class Pay{
	@RequestMapping(path={"pay.do"},method=RequestMethod.POST/*,consumes={MediaType.APPLICATION_JSON_VALUE}*/)
	ModelAndView payController(@RequestBody Map<String,Object> req){
		ModelAndView mav = new ModelAndView();
		
		//verify signature data
		String signData = (String)req.get("signData");
		try {
			checkSignature(signData);
		} catch (QiBankException e) {
			mav.setViewName("error");
			mav.addObject("errorCode",e.getErrCode());
			mav.addObject("errorMsg",e.getMessage());
			return mav;
		}
		
		
		//return order info 
		
		String method = (String)req.get("method");
		if(method==null||method.isEmpty()){
			mav.setViewName("error");
			mav.addObject("errorCode",Constants.ERRORCODE_UNKOWN_REQUEST_METHOD);
			mav.addObject("errorMsg",Constants.ERROR_UNKOWN_REQUEST_METHOD);
			return mav;
		}
		mav.setViewName("pay");
		PayResponseEntity entity = new PayResponseEntity();
		entity.setOrderNo((String)req.get("orderNo"));//get db sequence
		entity.setOrderAmount((String)req.get("orderAmount"));
		entity.setOrderTime((String)req.get("orderTime"));
		entity.setMerchantName((String)req.get("merchantName"));//get from db merchant table
		entity.setOrderRemark((String)req.get("orderRemark"));
		mav.addObject("result", entity);
		return mav;
	}
	
	private void checkSignature(String signData) throws QiBankException{
		//verify signature data
	}
}
