import React from 'react';
import { createRoot } from 'react-dom/client';
import {BrowserRouter} from 'react-router-dom';
import App from './app';

const domNode = document.getElementById('expense');
const root = createRoot(domNode);

root.render(
  <React.StrictMode>
    
    <BrowserRouter>
      <App/>
    </BrowserRouter>
    
  </React.StrictMode>
);
