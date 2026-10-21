import { request } from '@umijs/max';
import type { API } from '@/services/grapi-backend/typings';

/** 分页获取接口列表 GET /api/interfaceinfo/list/page */
export async function listInterfaceInfoByPageUsingGet(
  params: API.InterfaceInfoQueryRequest,
  options?: { [key: string]: any },
) {
  return request<{ records: API.InterfaceInfo[]; total: number }>(
    '/api/interfaceinfo/list/page',
    {
      method: 'GET',
      params: { ...params },
      ...(options || {}),
    },
  );
}

/** 新增接口 POST /api/interfaceinfo/add */
export async function addInterfaceInfoUsingPost(
  body: API.InterfaceInfo,
  options?: { [key: string]: any },
) {
  return request<number>('/api/interfaceinfo/add', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    data: body,
    ...(options || {}),
  });
}

/** 删除接口 POST /api/interfaceinfo/delete */
export async function deleteInterfaceInfoUsingPost(
  body: API.DeleteRequest,
  options?: { [key: string]: any },
) {
  return request<boolean>('/api/interfaceinfo/delete', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    data: body,
    ...(options || {}),
  });
}

/** 更新接口 POST /api/interfaceinfo/update */
export async function updateInterfaceInfoUsingPost(
  body: API.InterfaceInfo,
  options?: { [key: string]: any },
) {
  return request<boolean>('/api/interfaceinfo/update', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    data: body,
    ...(options || {}),
  });
}
