import React from 'react';
import AnimalService from "../Services/AnimalService"

class InsertPicture extends React.Component{
    constructor(props){
        super(props);
        this.state={
            image: undefined,
        }
    }

    fileSelectedHandler= event =>{
        this.setState({
            image: event.target.files[0],
        });
    }

    fileSubmitHandler=()=>{
        AnimalService.upload(this.state.image).then(()=>{
            return AnimalService.getFiles();

            })
            this.setState({
                image: undefined,
              });
        
    }
    render(){
        return(
            <div>
                <input type="file" onChange={this.fileSelectedHandler}/>
                <button onClick={this.fileSubmitHandler}>Add Image</button>
            </div>
        )
    }
    
}export default InsertPicture;
