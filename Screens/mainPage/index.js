import React,{useState} from 'react';
import { StyleSheet, View, Button } from 'react-native';
import { SearchBar } from 'react-native-elements';




export default function App(){
const [search,setSearch] = useState('');

    
    
    return(

            <View>
                    <SearchBar

                        placeholder="Type here..."
                        onChangeText ={ (e)=>  { setSearch(e); console.log(e);} }
                        value = {search}
                    
                    />

            </View>

    );
}





const styles = StyleSheet.create({
    title: {
     
    },



  });
  