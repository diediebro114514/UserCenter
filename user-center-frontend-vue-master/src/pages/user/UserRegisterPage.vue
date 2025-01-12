<template>
  <div id="userRegisterPage">
    <h2 class="title">User Registration</h2>
    <a-form
      style="max-width: 480px; margin: 0 auto"
      :model="formState"
      name="basic"
      label-align="left"
      :label-col="{ span: 4 }"
      :wrapper-col="{ span: 20 }"
      autocomplete="off"
      @finish="handleSubmit"
    >
      <a-form-item
        label="Account"
        name="userAccount"
        :rules="[{ required: true, message: 'Please enter your account' }]"
      >
        <a-input
          v-model:value="formState.userAccount"
          placeholder="Please enter your account"
        />
      </a-form-item>
      <a-form-item
        label="Password"
        name="userPassword"
        :rules="[
          { required: true, message: 'Please enter your password' },
          { min: 8, message: 'Password must be at least 8 characters' },
        ]"
      >
        <a-input-password
          v-model:value="formState.userPassword"
          placeholder="Please enter your password"
        />
      </a-form-item>
      <a-form-item
        label="Confirm Password"
        name="checkPassword"
        :rules="[
          { required: true, message: 'Please enter your confirm password' },
          { min: 8, message: 'Confirm password must be at least 8 characters' },
        ]"
      >
        <a-input-password
          v-model:value="formState.checkPassword"
          placeholder="Please enter your confirm password"
        />
      </a-form-item>
      <a-form-item
        label="Code"
        name="planetCode"
        :rules="[{ required: true, message: 'Please enter the code' }]"
      >
        <a-input
          v-model:value="formState.planetCode"
          placeholder="Please enter the code"
        />
      </a-form-item>
      <a-form-item :wrapper-col="{ offset: 4, span: 20 }">
        <a-button type="primary" html-type="submit">Register</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from "vue";
import { userRegister } from "@/api/user";
import { message } from "ant-design-vue";
import { useRouter } from "vue-router";

interface FormState {
  userAccount: string;
  userPassword: string;
  checkPassword: string;
  planetCode: string;
}

const formState = reactive<FormState>({
  userAccount: "",
  userPassword: "",
  checkPassword: "",
  planetCode: "",
});

const router = useRouter();

/**
 * Submit Form
 * @param values
 */
const handleSubmit = async (values: any) => {
  // Check if the two entered passwords are consistent
  if (formState.userPassword !== formState.checkPassword) {
    message.error("The passwords entered twice do not match");
    return;
  }
  const res = await userRegister(values);
  // If registration is successful, navigate to the login page
  if (res.data.code === 0 && res.data.data) {
    message.success("Registration successful");
    router.push({
      path: "/user/login",
      replace: true,
    });
  } else {
    message.error("Registration failed, " + res.data.description);
  }
};
</script>

<style scoped>
#userRegisterPage .title {
  text-align: center;
  margin-bottom: 16px;
}
</style>
