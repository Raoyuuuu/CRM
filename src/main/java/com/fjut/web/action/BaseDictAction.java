package com.fjut.web.action;

import com.fjut.domain.BaseDict;
import com.fjut.service.BaseDictService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/9 9:13
 * @param:
 * @return:
 * @throws:
 */
public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

    private BaseDict baseDict = new BaseDict();
    @Override
    public BaseDict getModel() {
        return baseDict;
    }

    private BaseDictService baseDictService;
    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }

    //通过字典类别代码获取字典数据
    public String findByTypeCode() throws IOException {
          System.out.println("方法执行");
          List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());

          JsonConfig jsonConfig = new JsonConfig();
          jsonConfig.setExcludes(new String[]{"dict_sort","dict_enable","dict_memo"});
          JSONArray jsonArray =  JSONArray.fromObject(list,jsonConfig);
          System.out.println(jsonArray.toString());

        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
          return NONE;
    }
}
