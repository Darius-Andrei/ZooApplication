import React from "react";
import AnimalService from "../Services/AnimalService";

class UpdateAnimals extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      id: null,
      name: "",
      animalClass: "",
      animalOrder: "",
      animalFamily: "",
      animalGenusAndSpecies: "",
      description: "",
      wikipediaURL: "",
      url: "",
    };
  }

  onChangeAttributes = e => {
    e.preventDefault();
    const val = e.target.value;
    this.setState({
      [e.target.name]: val,
    });
  };

  editAnimalFields = (e) => {
    var data = {
      id: this.state.id,
      name: this.state.name,
      animalClass: this.state.animalClass,
      animalOrder: this.state.animalOrder,
      animalFamily: this.state.animalFamily,
      animalGenusAndSpecies: this.state.animalGenusAndSpecies,
      description: this.state.description,
      url: this.state.url,
      wikipediaURL: this.state.wikipediaURL,
    };

    AnimalService.updateAnimals(this.props.toChange, data);
  };

  render() {
    return (
      <div>
        <form className='myform'>
          <label htmlFor='name'>Update:</label>
          <input
            type='text'
            className='form-control'
            id='name'
            name='name'
            placeholder='Name'
            value={this.state.name}
            onChange={this.onChangeAttributes}
          />
          <input
            type='text'
            className='form-control'
            id='animalClass'
            name='animalClass'
            placeholder='Class'
            value={this.state.animalClass}
            onChange={this.onChangeAttributes}
          />
          <input
            type='text'
            className='form-control'
            id='animalOrder'
            name='animalOrder'
            placeholder='Order'
            value={this.state.animalOrder}
            onChange={this.onChangeAttributes}
          />
          <input
            type='text'
            className='form-control'
            id='animalFamily'
            name='animalFamily'
            placeholder='Family'
            value={this.state.animalFamily}
            onChange={this.onChangeAttributes}
          />
          <input
            type='text'
            className='form-control'
            id='animalGenusAndSpecies'
            name='animalGenusAndSpecies'
            placeholder='GenusAndSpecies'
            value={this.state.animalGenusAndSpecies}
            onChange={this.onChangeAttributes}
          />
          <input
            type='text'
            className='form-control'
            id='description'
            name='description'
            placeholder='Description'
            value={this.state.description}
            onChange={this.onChangeAttributes}
          />
           <input
          type='text'
          className='form-control'
          id='url'
          name='url'
          placeholder='ImageURL'
          value={this.state.url}
          onChange={this.onChangeAttributes}
        />
        <input
          type='text'
          className='form-control'
          id='wikipediaURL'
          name='wikipediaURL'
          placeholder='Wikipedia Page URL'
          value={this.state.wikipediaURL}
          onChange={this.onChangeAttributes}
        />
          <button
            type='submit'
            onClick={this.editAnimalFields}
            className='btn btn-success'
          >
            Submit me
          </button>
        </form>
      </div>
    );
  }
}

export default UpdateAnimals;
