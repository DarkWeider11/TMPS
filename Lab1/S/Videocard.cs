using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.S
{
    public class Videocard
    {
        private string videocardName;
        public Videocard(string videocardName)
        {
            this.videocardName = videocardName;
        }

        public void RenderImage()
        {
            Console.WriteLine("*rendering full-hd video...*");
        }
    }
}
