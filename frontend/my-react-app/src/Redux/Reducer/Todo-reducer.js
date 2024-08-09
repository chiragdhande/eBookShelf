import { AddUser } from "../Actions/Action-type";

const initialState = {
   user: null // Initially, there's no user data
 };
 
 export const Todoreducer = (state = initialState, action) => {
   switch (action.type) {
     case AddUser:
       console.log("add user");
       console.log(action.payload);
       return {
         ...state,
         user: action.payload // Update user data in the state
        
       };
        
       
     default:
       return state;
   }
  

 };