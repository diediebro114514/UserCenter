<template>
  <div id="userManagePage">
    <a-input-search
      style="max-width: 320px; margin-bottom: 20px"
      v-model:value="searchValue"
      placeholder="input username"
      enter-button="search"
      size="large"
      @search="onSearch"
    />
    <a-table :columns="columns" :data-source="data">
      <template #bodyCell="{ column, record }">
        <template v-if="column.dataIndex === 'avatarUrl'">
          <a-image :src="record.avatarUrl" :width="120" />
        </template>
        <template v-else-if="column.dataIndex === 'userRole'">
          <div v-if="record.userRole === 1">
            <a-tag color="green">manager</a-tag>
          </div>
          <div v-else>
            <a-tag color="blue">simple user</a-tag>
          </div>
        </template>
        <template v-else-if="column.dataIndex === 'createTime'">
          {{ dayjs(record.createTime).format("YYYY-MM-DD HH:mm:ss") }}
        </template>
        <template v-else-if="column.key === 'action'">
          <a-button danger @click="doDelete(record.id)">delete</a-button>
        </template>
      </template>
    </a-table>
  </div>
</template>
<script lang="ts" setup>
import { deleteUser, searchUsers } from "@/api/user";
import { ref } from "vue";
import { message } from "ant-design-vue";
import dayjs from "dayjs";

const searchValue = ref("");
// 获取数据
const onSearch = () => {
  fetchData(searchValue.value);
};

// 删除数据
const doDelete = async (id: string) => {
  if (!id) {
    return;
  }
  const res = await deleteUser(id);
  if (res.data.code === 0) {
    message.success("success");
  } else {
    message.error("fail");
  }
};

const columns = [
  {
    title: "id",
    dataIndex: "id",
  },
  {
    title: "username",
    dataIndex: "username",
  },
  {
    title: "userAccount",
    dataIndex: "userAccount",
  },
  {
    title: "avatarUrl",
    dataIndex: "avatarUrl",
  },
  {
    title: "gender",
    dataIndex: "gender",
  },
  {
    title: "createTime",
    dataIndex: "createTime",
  },
  {
    title: "userRole",
    dataIndex: "userRole",
  },
  {
    title: "action",
    key: "action",
  },
];

// data
const data = ref([]);

// fetchData
const fetchData = async (username = "") => {
  const res = await searchUsers(username);
  if (res.data.data) {
    data.value = res.data.data;
  } else {
    message.error("fail to fetchData");
  }
};

fetchData();
</script>
