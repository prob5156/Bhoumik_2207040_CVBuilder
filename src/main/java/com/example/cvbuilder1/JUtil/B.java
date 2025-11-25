package com.example.cvbuilder1.JUtil;

import com.example.cvbuilder1.model.CVRecord;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class B
{

    private static final String c = "jdbc:sqlite:cv_records_direct.db";
    private static Connection d;

    private static final String e =
            "CREATE TABLE IF NOT EXISTS cv_nodes (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "email TEXT NOT NULL," +
                    "phone TEXT," +
                    "address TEXT," +
                    "summary TEXT," +
                    "education TEXT," +
                    "experience TEXT," +
                    "skills TEXT" +
                    ");";

    public static void f() throws SQLException
    {
        try
        {
            if (d == null || d.isClosed())
            {
                d = DriverManager.getConnection(c);
                g();
            }
        }
        catch (SQLException a)
        {
            throw new RuntimeException(a);
        }
    }

    public static void g() throws SQLException
    {
        try
        {
            PreparedStatement a = d.prepareStatement(e);
            a.executeUpdate();
        }
        catch (SQLException a)
        {
            throw new RuntimeException(a);
        }
    }

    public static List<CVRecord> h() throws SQLException
    {
        List<CVRecord> a = new ArrayList<>();
        String b = "SELECT * FROM cv_nodes ORDER BY id ASC";

        try (PreparedStatement c = d.prepareStatement(b);
             ResultSet k = c.executeQuery())
        {
            while (k.next())
            {
                int l = k.getInt("id");
                String n = k.getString("name");
                String o = k.getString("email");
                String p = k.getString("phone");
                String q = k.getString("address");
                String r = k.getString("summary");
                String s = k.getString("education");
                String t = k.getString("experience");
                String u = k.getString("skills");
                a.add(new CVRecord(l, n, o, p, q, r, s, t, u));
            }
        }
        return a;
    }

    public static CVRecord i(String b, String c, String d, String e, String f, String g, String h, String i) throws SQLException
    {
        String k = "INSERT INTO cv_nodes (name, email, phone, address, summary, education, experience, skills) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(B.c);
             PreparedStatement ps = conn.prepareStatement(k, Statement.RETURN_GENERATED_KEYS))
        {
            ps.setString(1, b);
            ps.setString(2, c);
            ps.setString(3, d);
            ps.setString(4, e);
            ps.setString(5, f);
            ps.setString(6, g);
            ps.setString(7, h);
            ps.setString(8, i);
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys())
            {
                if (keys.next())
                {
                    int a = keys.getInt(1);
                    return new CVRecord(a, b, c, d, e, f, g, h, i);
                }
                else
                {
                    throw new SQLException("Failed to retrieve generated id.");
                }
            }
        }
    }

    public static void j(CVRecord a) throws SQLException
    {
        String c = "UPDATE cv_nodes SET name = ?, email = ?, phone = ?, address = ?, summary = ?, education = ?, experience = ?, skills = ? WHERE id = ?";

        try (PreparedStatement d = B.d.prepareStatement(c))
        {
            d.setString(1, a.b());
            d.setString(2, a.c());
            d.setString(3, a.d());
            d.setString(4, a.e());
            d.setString(5, a.f());
            d.setString(6, a.g());
            d.setString(7, a.h());
            d.setString(8, a.i());
            d.setInt(9, a.a());
            d.executeUpdate();
        }
    }

    public static void k(int a) throws SQLException
    {
        String b = "DELETE FROM cv_nodes WHERE id = ?";

        try (PreparedStatement c = d.prepareStatement(b))
        {
            c.setInt(1, a);
            c.executeUpdate();
        }
    }
}