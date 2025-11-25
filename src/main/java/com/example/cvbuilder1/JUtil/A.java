package com.example.cvbuilder1.JUtil;

import org.json.JSONObject;

public class A
{

    public static String a(String b, String c, String d, String e, String f, String g, String h, String i)
    {
        return "{\"b\":\"" + b + "\",\"c\":\"" + c + "\",\"d\":\"" + d + "\",\"e\":\"" + e + "\",\"f\":\"" + f + "\",\"g\":\"" + g + "\",\"h\":\"" + h + "\",\"i\":\"" + i + "\"}";
    }

    public static String a(String b, String j)
    {
        JSONObject k = new JSONObject(j);
        return k.getString(b);
    }
}