package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 7/17/2019.
 */

public class LoginResponse
{
        @SerializedName("username")
        private String username;
        @SerializedName("employee_id")
        private String employee_id;
        @SerializedName("auth_role")
        private int auth_role;
        @SerializedName("response_code")
        private int response_code;
        @SerializedName("response_status")
        private String response_status;

        public LoginResponse(String username, String employee_id, int auth_role, int response_code, String response_status)
        {
            this.username = username;
            this.employee_id = employee_id;
            this.auth_role = auth_role;
            this.response_code = response_code;
            this.response_status = response_status;
        }

        public String getUsername()
        {
            return username;
        }

        public String getEmployee_id()
        {
            return employee_id;
        }

        public int getAuth_role()
        {
            return auth_role;
        }

        public int getResponse_code()
        {
            return response_code;
        }

        public String getResponse_status()
        {
            return response_status;
        }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setEmployee_id(String employee_id)
    {
        this.employee_id = employee_id;
    }

    public void setAuth_role(int auth_role)
    {
        this.auth_role = auth_role;
    }

    public void setResponse_code(int response_code)
    {
        this.response_code = response_code;
    }

    public void setResponse_status(String response_status)
    {
        this.response_status = response_status;
    }
}
