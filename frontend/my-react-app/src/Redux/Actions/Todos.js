import { AddTodo, AddUser, DeleteTodo, GetUser, UpdateTodo } from "./Action-type";

export const addtodo=(todo)=>(
    {
     type:AddUser,
     payload:todo
    }
)

export const adduser=(user)=>(
    {
        type:AddUser,
        payload:user
    }
)

export const getuser=(user)=>(
    {
        type:GetUser,
        payload:user
    }
)

export const deletetodo=(id)=>(
    {
        type:DeleteTodo,
        payload:id
    }
)
export const updatodo=(todo,id)=>(
    {
        type:UpdateTodo,
        payload:todo,id
    }
)
