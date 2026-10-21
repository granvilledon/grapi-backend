declare module 'slash2';
declare module '*.css';
declare module '*.less';
declare module '*.scss';
declare module '*.sass';
declare module '*.svg';
declare module '*.png';
declare module '*.jpg';
declare module '*.jpeg';
declare module '*.gif';
declare module '*.bmp';
declare module '*.tiff';
declare module 'omit.js';
declare module 'numeral';
declare module '@antv/data-set';
declare module 'mockjs';
declare module 'react-fittext';
declare module 'bizcharts-plugin-slider';

declare const REACT_APP_ENV: 'test' | 'dev' | 'pre' | false;

/**
 * 全局状态类型
 */
interface InitialState {
  loginUser?: UserVO;
}

/**
 * 当前登录用户视图（后端 UserVO）
 */
interface UserVO {
  id?: number;
  userName?: string;
  userAccount?: string;
  userAvatar?: string;
  gender?: number;
  userRole?: string;
  createTime?: string;
  updateTime?: string;
}
