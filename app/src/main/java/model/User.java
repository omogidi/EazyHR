package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 7/17/2019.
 */

public class User
{
    private String un;
    private String pwd;

    public User(String un, String pwd)
    {
        this.un = un;
        this.pwd = pwd;
    }

    public String getUn()
    {
        return un;
    }

    public String getPwd()
    {
        return pwd;
    }


}
