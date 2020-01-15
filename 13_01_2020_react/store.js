import { createStore } from "redux";

const initialState={
    Ddata:[],
    userInput:""
}

function reducer(state=initialState,action){
    console.log(action.val);
    switch (action.type){
        case "add":
            return {
                ...state,
                Ddata:state.Ddata.concat(action.val)
            }
        case "differ":return {
            ...state,
            userInput:action.val
        }
        default :
            return {...state};    
    }
}

let store=createStore(reducer);

export default store;
