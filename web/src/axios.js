import axios from 'axios'

axios.defaults.baseURL = process.env.VUE_APP_API_SERVER_URL

axios.interceptors.response.use((response) => {
    if (response.status === 200) {
        return response
    } else {
        return Promise.reject({
            status: response.status,
            error: response.data.error
        })
    }
}, (error) => {
    return Promise.reject({
        status: 500,
        error: 'Internal Server Error'
    })
})

export default axios