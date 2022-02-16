package com.faas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openfaas.model.AbstractHandler;
import com.openfaas.model.IRequest;
import com.openfaas.model.IResponse;
import com.openfaas.model.Response;
import org.apache.commons.lang3.StringUtils;

import java.lang.management.ManagementFactory;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Handler
 * @Description: TODO
 * @Author: wilson
 * @Date: 2022/2/14 14:58
 * @Version: v1.0
 */
public class Handler extends AbstractHandler {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public IResponse Handle(IRequest req) {
        Map<String, Object> rlt = new HashMap<>();
        rlt.put("success", true);
        rlt.put("message", "java template");

        String rltStr = null;
        try {
            rltStr = mapper.writeValueAsString(rlt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Response res = new Response();
        res.setContentType("application/json;charset=utf-8");
        res.setBody(rltStr);

        return res;
    }


}
