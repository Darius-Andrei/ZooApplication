import React from "react";
import AnimalService from "../Services/AnimalService";
import UpdateAnimals from "./UpdateAnimals";

class RenderAnimal extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      animals: [],
      changeMe: null,
    };
  }

  componentDidMount() {
    this.renderAllAnimals();
  }

  renderAllAnimals() {
    AnimalService.fetchAnimals()
      .then(r => {
        this.setState({
          animals: r.data,
        });
      })
      .catch(e => console.log(e));
  }

  render() {
    return (
      <div className='animals'>
        {this.state.animals &&
          this.state.animals.map(a => {
            return (
              <div key={a.id}>
               <img alt="" src="*{'data:image/jpg:base64,'+{a.image}}"/> {a.id} {a.name}{" "}{a.description}
                <button
                  type='submit'
                  onClick={() => {
                    AnimalService.deleteAnimal(a.id);
                    window.location.reload();
                  }}
                >
                  Delete me
                </button>
                <button
                  type='submit'
                  onClick={() => {
                    this.setState({ changeMe: a.id });
                  }}
                >
                  Edit me
                </button>
              </div>
            );
          })}
        <div className='editform'>
          <UpdateAnimals toChange={this.state.changeMe} />
        </div>
      </div>
    );
  }
}

export default RenderAnimal;
