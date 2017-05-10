package JuegoPrueba;



import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class personaje extends JPanel implements ActionListener, KeyListener {

	
	
	//declarar controles a usar y definir valor
        //tambien se define la ruta de donde se selecciona la imagen
	Timer tiempo = new Timer(10,this);
	int x = 0, y = 0, velX, velY;
	Image imagen;
	
        Image fondo;
        File rutafondo = new File("mapa.png");
	File ruta = new File("fren2.png");
        
        int alto = 600;
        int ancho = 700;
        
        
        
        
        
	public personaje(){
		
		//sirve para que inicien las teclas
		
		tiempo.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
                /* esto es una excepcion(aviso)
                para dar un aviso por si no encuentra la imagen */
                
                //ruta para el aviso del personaje
                try{
			imagen = ImageIO.read(ruta);
		}
		catch(IOException e){
			System.out.println("No se encunetra la imagen");
		}
                
                //aviso para ruta del mapa
                 try{
			fondo = ImageIO.read(rutafondo);
		}
		catch(IOException e){
			System.out.println("No se encunetra la imagen");
		}
				
	}
	
	
	public void init(){}
	
        //estas son coordenadas y tamaño de la imagen que se ha puesto
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		//g.setColor(Color.GREEN);
		//g.fillRect(x, y, 50, 40);
                
                
               //ImageIcon fondo = new ImageIcon(new ImageIcon(getClass().getResource("mapazelda.jpg")).getImage());
                
               //g.drawImage(fondo.getImage(),0,0 ,1280,720, null);
                
                
                //fondo o mapa que se va a poner
                g.drawImage(fondo, 0,0,ancho,alto, null);
               
                //imagen, la cual va a estar en movimineto
                g.drawImage(imagen, x,y,100,100, null);
                
                
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		x = x + velX;
		y = y + velY;
		repaint();
                
                //los siguientes bucles son para delimimitar la zona por donde se mueve el personaje
                if(x < 0){
			
			velX = 0;
			x = 0;
						
		}
		
		if(x > 590){
			
			velX = 0;
			x = 590;
		
		}
		
		if(y < 0){
			
			velY = 0;
			y = 0;
			
		}
		
		if(y > 450){
			
			velY = 0;
			y = 450;
			
		}
		
		x = x + velX;
		y = y + velY;
		repaint();
		
	}
           

	public void keyPressed1(KeyEvent e) {
	
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
		
	}

        //en este apartado he puesto bucles con coordenadas para mover el personaje
	@Override
	public void keyPressed(KeyEvent e) {
		
		int b = e.getKeyCode();
        
        if(b == KeyEvent.VK_LEFT){
        
            //aqui he puesto imagenes para hiciera los movimientos de andar
            //en esta imagen camina hacia la izquierda
            
            File ruta = new File("izq2.png");
            
            /* esto es una excepcion(aviso)
            para dar un aviso por si no encuentra la imagen */
            
            try{
			imagen = ImageIO.read(ruta);
		}
		catch(IOException a){
			System.out.println("No se encunetra la imagen");
		}
            
            velX = -1;
            velY = 0;
        }
            
        if(b == KeyEvent.VK_UP){
            
            //en esta imagen camina hacia arriba
            
            File ruta = new File("arr2.png");
            
            
            /* esto es una excepcion(aviso)
            para dar un aviso por si no encuentra la imagen */
          
            try{
			imagen = ImageIO.read(ruta);
		}
		catch(IOException a){
			System.out.println("No se encunetra la imagen");
		}

            velX = 0;
            velY = -1;
        }
        if(b == KeyEvent.VK_RIGHT){
            
            
            //en esta otra camina hacia la derecha
            File ruta = new File("der2.png");
            
            
            /* esto es una excepcion(aviso)
            para dar un aviso por si no encuentra la imagen */
            try{
			imagen = ImageIO.read(ruta);
		}
		catch(IOException a){
			System.out.println("No se encunetra la imagen");
		}
            
            velX = 1;
            velY = 0;
        }
        if(b == KeyEvent.VK_DOWN){
            
            //en esta imagen camina de frente            
            File ruta = new File("fren2.png");
            
            
            /* esto es una excepcion(aviso)
            para dar un aviso por si no encuentra la imagen */
            try{
			imagen = ImageIO.read(ruta);
		}
		catch(IOException a){
			System.out.println("No se encunetra la imagen");
		}
            
            velX = 0;
            velY = 1;
        }
		
	}


	public void actionReleased(ActionEvent e) {
		
		
	}
	
        //esta parte se usa para que el personaje no se mueva solo y lo tengas que mover tu mismo
	@Override
	public void keyReleased(KeyEvent e) {
		
        int b = e.getKeyCode();
        
        if(b == KeyEvent.VK_LEFT){
          
            
            
            velX = 0;
            velY = 0;
        }
            
        if(b == KeyEvent.VK_UP){
                                   
            velX = 0;
            velY = 0;
        }
        if(b == KeyEvent.VK_RIGHT){
                        
            velX = 0;
            velY = 0;
        }
        if(b == KeyEvent.VK_DOWN){
                        
            velX = 0;
            velY = 0;
        }
		
		
	}
	
	
	//aqui se crea la venta junto con el tamaño
	public static void main(String[] arg){
		
		personaje ver = new personaje();
		JFrame form = new JFrame();
		form.setTitle("en movimiento");
		form.setSize(ver.ancho,ver.alto);
		form.setVisible(true);
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.add(ver);
		form.setResizable(false);
		
	}


	
	
}
