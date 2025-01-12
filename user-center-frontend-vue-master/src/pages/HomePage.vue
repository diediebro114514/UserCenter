<template>
  <div id="homePage">
    <!-- Hero Section -->
    <section class="hero">
      <div class="container">
        <h1>Welcome to MyApp</h1>
        <p>Your one-stop solution for all your needs.</p>
        <a-button type="primary" size="large" @click="getStarted"
          >Get Started</a-button
        >
      </div>
    </section>

    <!-- Features Section -->
    <section id="features" class="features">
      <div class="container">
        <h2>Features</h2>
        <div class="feature-cards">
          <div class="card" v-for="feature in features" :key="feature.title">
            <div class="icon">{{ feature.icon }}</div>
            <h3>{{ feature.title }}</h3>
            <p>{{ feature.description }}</p>
          </div>
        </div>
      </div>
    </section>

    <!-- About Section -->
    <section id="about" class="about">
      <div class="container">
        <h2>About Us</h2>
        <p>
          MyApp is designed to simplify your life by providing powerful tools
          and an intuitive user experience.
        </p>
      </div>
    </section>

    <!-- Contact Section -->
    <section id="contact" class="contact">
      <div class="container">
        <h2>Contact Us</h2>
        <a-form @finish="handleContactFormSubmit">
          <a-form-item
            name="name"
            label="Name"
            :rules="[{ required: true, message: 'Please enter your name' }]"
          >
            <a-input v-model="contactForm.name" />
          </a-form-item>
          <a-form-item
            name="email"
            label="Email"
            :rules="[{ required: true, message: 'Please enter your email' }]"
          >
            <a-input v-model="contactForm.email" />
          </a-form-item>
          <a-form-item
            name="message"
            label="Message"
            :rules="[{ required: true, message: 'Please enter your message' }]"
          >
            <a-textarea v-model="contactForm.message" />
          </a-form-item>
          <a-button type="primary" html-type="submit">Submit</a-button>
        </a-form>
      </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
      <div class="container">
        <p>&copy; 2025 MyApp. All rights reserved.</p>
      </div>
    </footer>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from "vue";
import { useRouter } from "vue-router";
import { message } from "ant-design-vue";

const router = useRouter();

const features = [
  { icon: "🔥", title: "Fast", description: "Lightning-fast performance." },
  { icon: "🔒", title: "Secure", description: "Your data is safe with us." },
  { icon: "✨", title: "Intuitive", description: "Designed for simplicity." },
];

const contactForm = reactive({
  name: "",
  email: "",
  message: "",
});

const getStarted = () => {
  router.push("/get-started");
};

const handleContactFormSubmit = () => {
  message.success("Thank you for contacting us. We'll get back to you soon.");
};
</script>

<style scoped>
/* General Styles */
body {
  margin: 0;
  font-family: Arial, sans-serif;
}

/* Hero Section */
.hero {
  background: #f0f2f5;
  text-align: center;
  padding: 5rem 1rem;
}
.hero h1 {
  font-size: 2.5rem;
  margin-bottom: 1rem;
}
.hero p {
  font-size: 1.25rem;
  margin-bottom: 2rem;
}

/* Features Section */
.features {
  background: #fff;
  padding: 3rem 1rem;
}
.features h2 {
  text-align: center;
  margin-bottom: 2rem;
}
.feature-cards {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}
.card {
  background: #f9f9f9;
  padding: 1.5rem;
  border-radius: 8px;
  text-align: center;
  width: 280px;
  margin: 1rem;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}
.card .icon {
  font-size: 2rem;
  margin-bottom: 1rem;
}
.card h3 {
  font-size: 1.25rem;
  margin-bottom: 0.5rem;
}

/* About Section */
.about {
  background: #f0f2f5;
  text-align: center;
  padding: 3rem 1rem;
}

/* Contact Section */
.contact {
  background: #fff;
  padding: 3rem 1rem;
}
.contact h2 {
  text-align: center;
  margin-bottom: 2rem;
}
.contact .container {
  max-width: 600px;
  margin: 0 auto;
}

/* Footer */
.footer {
  background: #001529;
  color: #fff;
  text-align: center;
  padding: 1rem 0;
}
</style>
