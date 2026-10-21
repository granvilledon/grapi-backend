import { request } from '@umijs/max';
import type { API } from '@/services/grapi-backend/typings';

/** 用户登录 POST /api/user/login */
export async function userLoginUsingPost(
  body: API.UserLoginRequest,
  options?: { [key: string]: any },
) {
  return request<API.UserVO>('/api/user/login', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    data: body,
    ...(options || {}),
  });
}

/** 用户注销 POST /api/user/logout */
export async function userLogoutUsingPost(options?: { [key: string]: any }) {
  return request<boolean>('/api/user/logout', {
    method: 'POST',
    ...(options || {}),
  });
}

/** 获取当前登录用户 GET /api/user/get/login */
export async function getLoginUserUsingGet(options?: { [key: string]: any }) {
  return request<API.UserVO>('/api/user/get/login', {
    method: 'GET',
    ...(options || {}),
  });
}
