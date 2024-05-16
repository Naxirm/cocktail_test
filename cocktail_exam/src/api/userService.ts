import axios from 'axios'

const API_URL = 'http://localhost:8080/users'

export const getUsers = () => {
  return axios.get(API_URL)
}

export const getUser = (id: number) => {
  return axios.get(`${API_URL}/${id}`)
}

export const createUser = (user: any) => {
  return axios.post(API_URL, user)
}

export const updateUser = (id: number, user: any) => {
  return axios.put(`${API_URL}/${id}`, user)
}

export const deleteUser = (id: number) => {
  return axios.delete(`${API_URL}/${id}`)
}
