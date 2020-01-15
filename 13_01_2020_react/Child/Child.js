import React from "react";

const Child=(props)=>{
    if(props.data.length>0){
        return (
            <div>
                <h2>clicked id:</h2>
                <div className="rightContent">
                <table> 
                <thead>
                    <th>Id</th>
                    <th>Country</th>
                    <th>State</th>
                    <th>City</th>
                </thead>           
                <tbody>
                    {props.data.map((ele,index)=>{
                        return <tr key={`${index}`}>
                            <td>{ele.id}</td>
                            <td>{ele.country}</td>
                            <td>{ele.state}</td>
                            <td>{ele.city}</td>
                        </tr>   
                    })
                }
                </tbody>
                </table>
            </div>                 
            </div>    
        );
    }
    else{
        return(
            <div></div>
        )
    }

}

export default Child;