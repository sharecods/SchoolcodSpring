import {
  ADD_TODO,
  REMOVE_TODO,
  CLEAR_ALL,
  RESTORE,
  EDIT_TODO,
  TOGGLE_TODO_STATUS,
  FETCH_BOARD_LIST,
  FETCH_BOARD
} from './mutation-types'

export default {
  editTodo ({ commit }, payload) {
    commit(EDIT_TODO, payload)
  },
  toggleTodoStatus ({ commit }, id) {
    commit(TOGGLE_TODO_STATUS, id)
  },
  save ({ state }) {
    const data = {
      todoItems: state.todoItems,
      nextTodoId: state.nextTodoId
    }
    localStorage.setItem('todo-app-data', JSON.stringify(data))
  },
  restore ({ commit }) {
    const data = localStorage.getItem('todo-app-data')

    if (data) {
      console.log('data: ' + JSON.parse(data))
      commit(RESTORE, JSON.parse(data))
    }
  },
  addTodo (context, payload) {
    context.commit(ADD_TODO, payload)
  },
  removeTodo (context, payload) {
    context.commit(REMOVE_TODO, payload)
  },
  clearAll (context) {
    context.commit(CLEAR_ALL)
  },
  fetchBoardList ({ commit }) {
    return axios.get('http://localhost:7777/boards')
        .then(res => {
          commit(FETCH_BOARD_LIST, res.data)
        })
  },
  fetchBoard ({ commit }, boardNo) {
    console.log('fetchBoard ' + commit + ', boardNo = ' + boardNo)
    return axios.get(`http://localhost:7777/boards/${boardNo}`)
        .then(res => {
          console.log('fetchBoard - res: ' + res.data)
          commit(FETCH_BOARD, res.data)
        })
  },
}