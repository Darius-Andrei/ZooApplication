import React, { useState } from "react";
import AnimalService from "../Services/AnimalService";

const InsertAnimal = props => {
  const [animalToAdd, setAnimal] = useState({
    id: null,
    name: "",
    description: "",
    animalClass: "",
    animalFamily: "",
    animalOrder: "",
    animalGenusAndSpecies: "",
    zooMap: "",
  });

  const [imageToAdd, setImage] = useState("");

  const onChangeForm = e => {
    setAnimal({ ...animalToAdd, [e.target.name]: e.target.value });
  };

  const fileSelectedHandler= e =>{
    setImage(e.target.files[0]);
  };


  const finishInsert = e => {
    e.preventDefault();
    var data = {
      id: animalToAdd.id,
      name: animalToAdd.name,
      description: animalToAdd.description,
      animalClass: animalToAdd.animalClass,
      animalFamily: animalToAdd.animalFamily,
      animalOrder: animalToAdd.animalOrder,
      animalGenusAndSpecies: animalToAdd.animalGenusAndSpecies,
      zooMap: animalToAdd.zooMap,
      url: animalToAdd.url,
      wikipediaURL: animalToAdd.wikipediaURL,
    };

      AnimalService.addAnimal(data).then( (response)=>{
        console.log(response.data);
        AnimalService.upload(response.data.id,imageToAdd)
      })
      //window.location.reload();
  };

  return (
    <div>
      <form className='myform'>
        <label htmlFor='username'>Create:</label>
        <input
          type='text'
          className='form-control'
          id='name'
          name='name'
          placeholder='name'
          value={animalToAdd.name}
          onChange={onChangeForm}
        />
        <input
          type='text'
          className='form-control'
          id='description'
          name='description'
          placeholder='description'
          value={animalToAdd.description}
          onChange={onChangeForm}
        />
        <input 
          type="file" 
          onChange={fileSelectedHandler}
        />
        <input
          type='text'
          className='form-control'
          id='animalClass'
          name='animalClass'
          placeholder='animalClass'
          value={animalToAdd.animalClass}
          onChange={onChangeForm}
        />
        <input
          type='text'
          className='form-control'
          id='animalFamily'
          name='animalFamily'
          placeholder='animalFamily'
          value={animalToAdd.animalFamily}
          onChange={onChangeForm}
        />
        <input
          type='text'
          className='form-control'
          id='animalOrder'
          name='animalOrder'
          placeholder='animalOrder'
          value={animalToAdd.animalOrder}
          onChange={onChangeForm}
        />
        <input
          type='text'
          className='form-control'
          id='animalGenusAndSpecies'
          name='animalGenusAndSpecies'
          placeholder='GenusAndSpecies'
          value={animalToAdd.animalGenusAndSpecies}
          onChange={onChangeForm}
        />
        <input
          type='text'
          className='form-control'
          id='url'
          name='url'
          placeholder='ImageURL'
          value={animalToAdd.url}
          onChange={onChangeForm}
        />
        <input
          type='text'
          className='form-control'
          id='wikipediaURL'
          name='wikipediaURL'
          placeholder='Wikipedia Page URL'
          value={animalToAdd.wikipediaURL}
          onChange={onChangeForm}
        />
        <button
          type='submit'
          onClick={finishInsert}
          className='btn btn-success'
        >
          Submit me
        </button>
      </form>
    </div>
  );
};

export default InsertAnimal;
