import instance from "axios";

const AxiosClient = instance.create({
  baseURL: "http://34.228.10.237:8080/",
});

AxiosClient.interceptors.request.use(async (config) => {
  const token = await JSON.parse(localStorage.getItem("token"));
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }

  return config;
});

export default AxiosClient;
