package com.definesys.totorial4.activiti.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/9/20 2:41 AM
 * @history: 1.2019/9/20 created by jianfeng.zheng
 */
public class ActivitiUtil {

    public static String text(InputStream fin) {
        byte[] buf = new byte[512];
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try {
            do {
                int size = fin.read(buf);
                if (size <= 0) {
                    break;
                }
                bout.write(buf, 0, size);
            } while (true);
            String text = new String(bout.toByteArray(), "UTF-8");
            bout.close();
            return text;
        } catch (Exception ex) {
            throw new RuntimeException("convert error");
        }
    }
}
