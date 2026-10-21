declare namespace API {
  /** 接口信息（对应后端 interface_info 表） */
  export type InterfaceInfo = {
    id?: number;
    name?: string;
    description?: string;
    url?: string;
    requestParams?: string;
    requestHeader?: string;
    responseHeader?: string;
    /** 接口状态（0-关闭，1-开启） */
    status?: number;
    /** 请求方法（GET / POST） */
    method?: string;
    userId?: number;
    createTime?: string;
    updateTime?: string;
  };

  /** 当前登录用户视图（后端 UserVO） */
  export type UserVO = {
    id?: number;
    userName?: string;
    userAccount?: string;
    userAvatar?: string;
    gender?: number;
    userRole?: string;
    createTime?: string;
    updateTime?: string;
  };

  /** 登录请求参数 */
  export type UserLoginRequest = {
    userAccount?: string;
    userPassword?: string;
  };

  /** 接口分页查询参数 */
  export type InterfaceInfoQueryRequest = {
    id?: number;
    name?: string;
    description?: string;
    url?: string;
    status?: number;
    method?: string;
    userId?: number;
    current?: number;
    pageSize?: number;
    sortField?: string;
    sortOrder?: string;
  };

  /** 通用删除请求（按 id） */
  export type DeleteRequest = {
    id?: number;
  };
}
