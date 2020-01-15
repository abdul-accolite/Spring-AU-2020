import React,{Component} from 'react';
import './App.css';
import Data from "./display.json";
import Child from "./Child/Child";
import {connect} from "react-redux";

class App extends Component {

  constructor(props){
    super(props);
  }

  render(){
      return (
        <div>
            <div className="left">
              <h2>Select an id</h2>
              <b>state name:</b> <input type="text" onChange={this.props.addToUserInput} value={this.props.userInput}/><br/><br/>
              <table>
                <thead>
                <tr>
                  <th>id</th>
                  <th>country</th>
                  <th>state</th>
                  <th>city</th>
                </tr>
                </thead>
                <tbody>
              {
                Data
                  .filter(elem=>{
                     const pat=new RegExp(this.props.userInput,"i");
                     return pat.test(elem.state);
                  })
                  .map((elem,index)=>{
                    return <tr key={`${index}`} onClick={this.props.addToDisplayData.bind(this,elem)}>
                  <td>{elem.id}</td>
                  <td>{elem.country}</td>
                  <td>{elem.state}</td>
                  <td>{elem.city}</td>
                  </tr>
                })
              }
              </tbody>
          </table>
        </div>
        <div className="right">
          <Child data={this.props.Ddata} />
        </div>
        </div>  
      )

  }
}


const stateToProps=state=>{
  return {
    Ddata:state.Ddata,
    userInput:state.userInput
  }
}

const dispatchToProps=dispatch=>{
  return {
    addToDisplayData:(data)=>{dispatch({type:"add",val:data})},
    addToUserInput:({target})=>{dispatch({type:"differ",val:target.value})}
  }
}

export default connect(stateToProps,dispatchToProps)(App);
  