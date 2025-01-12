package usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "user")
@Data
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    /**
     * acc
     */
    private String userAccount;

    /**
     * pfp
     */
    private String avatarUrl;

    /**
     * gender
     */
    private Integer gender;

    /**
     * password
     */
    private String userPassword;

    /**
     * num
     */
    private String phone;

    /**
     * email
     */
    private String email;

    /**
     * userStatus
     */
    private Integer userStatus;

    /**
     * createTime
     */
    private Date createTime;

    /**
     * updateTime
     */
    private Date updateTime;

    /**
     * isDelete
     */
    @TableLogic
    private Integer isDelete;

    /**
     * userRole
     */
    private Integer userRole;

    /**
     * planetCode
     */
    private String planetCode;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
