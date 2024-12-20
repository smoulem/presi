#
Set-Location 'C:\Users\smoulem\Documents\testfolder\prb008847\xps logs'
gci -Path .\ -Name -Recurse -Filter 'altair*log' | ForEach-Object { Select-String -Path ([string]$_) -Pattern 'PS5280BatchJob' -CaseSensitive }
gci -Path .\ -Name -Recurse -Filter 'altair*log'
gci -Path .\ -Name -Recurse -Filter 'altair*log*'
gci -Path .\ -Name -Recurse -Filter 'altair*log*' | ForEach-Object { Select-String -Path ([string]$_) -Pattern 'PS5280BatchJob' -CaseSensitive }
gci -Path .\ -Name -Recurse -Filter 'altair*log*' | ForEach-Object { Select-String -Path ([string]$_) -Pattern 'PS5280BatchJob' -CaseSensitive } | Set-Content -Path member_extracts.log
Set-Location ..\..\..\..\..\..\projects\git
gci -Path .\ -Filter "*.groovy" -Name
gci -Path .\ -Filter "*.groovy"
gci
gci -Path .\ -Filter *.groovy -Name
gci -Path . -Filter *.groovy -Name
gci -Path . -Filter *.groovy -Name gci
gci
gci .\altair\
gci -Path .\ -Filter *.groovy -Name -Recurse
gci -Path .\ -Filter *.groovy -Name -Recurse | Select-String "*image*"
gci -Path .\ -Filter *.groovy -Name -Recurse | Select-String -Pattern "*image*"
gci -Path .\ -Filter *.groovy -Name -Recurse | Select-String -Pattern "image"
get-location
Set-Location 'C:\Users\smoulem\Documents\testfolder\prb008847\xps logs'
#
# Write-Host "hello"

# gci 

# pwd

# wsl --install -d openSUSE-Leap-15.5

# $env:PATH += ';C:\Users\smoulem\Downloads\bin'

Set-Location 'C:\Users\smoulem\Documents\testfolder\prb008847\xps logs'

Select-String -Path 'C:\Users\smoulem\Documents\testfolder\prb008847\xps logs\altairmain-wrapper.log.1' -Pattern 'timeout' -CaseSensitive

gci -Path .\ -Name -Recurse -Filter 'altair*log*'

gci -Path .\ -Name -Recurse -Filter 'altair*log*' | ForEach-Object { Select-String -Path ([string]$_) -Pattern 'PS5280BatchJob' -CaseSensitive }

gci -Path .\ -Name -Recurse -Filter 'altair*log*' | ForEach-Object { Select-String -Path ([string]$_) -Pattern 'PS5280BatchJob' -CaseSensitive } | Set-Content -Path member_extracts.log

Set-Location ~




Set-Location C:\projects\git
gci -Path .\ -Filter *.groovy -Name -Recurse | Select-String -Pattern "image"
