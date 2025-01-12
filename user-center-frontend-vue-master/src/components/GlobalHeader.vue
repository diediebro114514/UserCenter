<template>
  <div id="globalHeader">
    <a-row :wrap="false">
      <a-col flex="200px">
        <div class="title-bar">
          <img class="logo" src="../assets/logo.png" alt="logo" />
          <div class="title">D D Fantasy</div>
        </div>
      </a-col>
      <a-col flex="auto">
        <a-menu
          v-model:selectedKeys="current"
          mode="horizontal"
          :items="items"
          @click="doMenuClick"
        />
      </a-col>
      <a-col flex="80px">
        <div class="user-login-status">
          <div v-if="loginUserStore.loginUser.id">
            {{ loginUserStore.loginUser.username ?? "anonymous" }}
          </div>
          <div v-else>
            <a-button type="primary" ghost href="/user/login">Login</a-button>
          </div>
        </div>
      </a-col>
    </a-row>
  </div>
</template>

<script lang="ts" setup>
import { h, ref } from "vue";
import {
  CrownOutlined,
  HomeOutlined,
  CarTwoTone,
  GithubFilled,
} from "@ant-design/icons-vue";
import { MenuProps } from "ant-design-vue";
import { useRouter } from "vue-router";
import { useLoginUserStore } from "@/store/useLoginUserStore";

const loginUserStore = useLoginUserStore();

const router = useRouter();
// jump to event
const doMenuClick = ({ key }: { key: string }) => {
  router.push({
    path: key,
  });
};

const current = ref<string[]>(["mail"]);
// update status
router.afterEach((to) => {
  current.value = [to.path];
});

const items = ref<MenuProps["items"]>([
  {
    key: "/",
    icon: () => h(HomeOutlined),
    label: "Main",
    title: "Main",
  },
  {
    key: "/user/login",
    icon: () => h(CarTwoTone),
    label: "User Login",
    title: "User Login",
  },
  {
    key: "/user/register",
    label: "User Register",
    title: "User Register",
  },
  {
    key: "/admin/userManage",
    icon: () => h(CrownOutlined),
    label: "User Admin",
    title: "User Admin",
  },
  {
    key: "others",
    icon: () => h(GithubFilled),
    label: h(
      "a",
      { href: "https://github.com/diediebro114514", target: "_blank" },
      "MyGithub"
    ),
    title: "MyGithub",
  },
]);
</script>

<style scoped>
.title-bar {
  display: flex;
  align-items: center;
}

.title {
  color: black;
  font-size: 18px;
  margin-left: 16px;
}

.logo {
  height: 48px;
}
</style>
