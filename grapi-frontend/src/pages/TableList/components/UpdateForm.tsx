import {
  ModalForm,
  ProFormSelect,
  ProFormText,
  ProFormTextArea,
} from '@ant-design/pro-components';
import '@umijs/max';
import { Modal } from 'antd';
import React from 'react';

export type FormValueType = Partial<API.InterfaceInfo>;

export type UpdateFormProps = {
  onCancel: (flag?: boolean, formVals?: FormValueType) => void;
  onSubmit: (values: FormValueType) => Promise<void>;
  updateModalOpen: boolean;
  values: Partial<API.InterfaceInfo>;
};

/**
 * 更新接口信息弹窗
 */
const UpdateForm: React.FC<UpdateFormProps> = (props) => {
  return (
    <Modal
      width={640}
      destroyOnClose
      title={'修改接口'}
      open={props.updateModalOpen}
      footer={null}
      onCancel={() => {
        props.onCancel();
      }}
    >
      <ModalForm<FormValueType>
        initialValues={props.values}
        onFinish={async (value) => {
          // 保留 id，后端按 id 更新
          await props.onSubmit({ ...value, id: props.values.id });
        }}
        modalProps={{ destroyOnClose: true }}
      >
        <ProFormText
          width="md"
          name="name"
          label="接口名称"
          rules={[
            {
              required: true,
              message: '接口名称为必填项',
            },
          ]}
        />
        <ProFormTextArea width="md" name="description" label="接口描述" />
        <ProFormText
          width="md"
          name="url"
          label="接口地址"
          rules={[
            {
              required: true,
              message: '接口地址为必填项',
            },
          ]}
        />
        <ProFormSelect
          width="md"
          name="method"
          label="请求方法"
          options={['GET', 'POST']}
          rules={[
            {
              required: true,
              message: '请求方法为必填项',
            },
          ]}
        />
        <ProFormTextArea width="md" name="requestHeader" label="请求头" />
        <ProFormTextArea width="md" name="responseHeader" label="响应头" />
      </ModalForm>
    </Modal>
  );
};
export default UpdateForm;
