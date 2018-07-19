package org.docksidestage.app.web.wx.json;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * white-box try
 * @author jflute
 */
@Controller
@RequestMapping("/wx/json")
public class WxJsonController {

    // http://localhost:8080/wx/json/emptybody
    @RequestMapping(method = RequestMethod.GET, value = "emptybody")
    @ResponseBody
    public void emptybody() { // contentType=null
        return;
    }

    // http://localhost:8080/wx/json/emptyobj
    // java.lang.IllegalArgumentException: No converter found for return value of type:
    // class org.docksidestage.app.web.wx.json.WxJsonController$EmptyObj
    @RequestMapping(method = RequestMethod.GET, value = "emptyobj")
    @ResponseBody
    public EmptyObj emptyobj() {
        return new EmptyObj();
    }

    public static class EmptyObj {
    }

    // http://localhost:8080/wx/json/emptylist
    @RequestMapping(method = RequestMethod.GET, value = "emptylist")
    @ResponseBody
    public List<String> emptylist() {
        return Arrays.asList();
    }

    // http://localhost:8080/wx/json/newobject
    // No converter found for return value of type: class java.lang.Object
    @RequestMapping(method = RequestMethod.GET, value = "newobject")
    @ResponseBody
    public Object newobject() {
        return new Object();
    }

    // http://localhost:8080/wx/json/strval
    @RequestMapping(method = RequestMethod.GET, value = "strval")
    @ResponseBody
    public String strval() { // contentType=text/html
        return "sea";
    }
}
