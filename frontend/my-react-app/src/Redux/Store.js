import { combineReducers } from 'redux';
import { createStore } from 'redux';
import { Todoreducer } from './Reducer/Todo-reducer';
const rootreducer=combineReducers({Todoreducer})
const store=createStore(rootreducer)
 export default store
